package kim.present.solve.backjoon

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

typealias TestCase = Pair<String, String>

open class TestBase {
    private val solutions = mutableListOf<Class<*>>()
    private var testcases = mutableListOf<TestCase>()

    fun test(appendTestcases: MutableList<TestCase>.() -> Unit) =
        testcases.apply(appendTestcases).flatMap { (input, expected) ->
            solutions.map { solution ->
                DynamicTest.dynamicTest("input = $input") {
                    val `in` = System.`in`
                    val `out` = System.out
                    val actual = ByteArrayOutputStream()

                    System.setIn(ByteArrayInputStream(input.toByteArray()))
                    System.setOut(PrintStream(actual))

                    try {
                        solution.getDeclaredMethod("main", Array<String>::class.java)
                            .invoke(null, arrayOf<String>() as Any)
                    } catch (e: Exception) {
                        Assertions.fail<Any>(e)
                    }

                    System.setIn(`in`)
                    System.setOut(`out`)

                    fun filter(input: String) = input.trim().replace("\r", "")
                    Assertions.assertEquals(filter(expected), filter(actual.toString()))
                }
            }
        }.also { testcases = mutableListOf() }

    operator fun Class<*>.unaryPlus() = solutions.add(this)
    operator fun String.not() = this.trimIndent()
    infix fun String.expected(expected: String) = testcases.add(TestCase(this, expected))
}