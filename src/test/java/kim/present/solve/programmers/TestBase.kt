package kim.present.solve.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.DynamicTest
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction3

typealias TestCase<ARGS, R> = Pair<ARGS, R>

abstract class TestBase<S : KFunction<R>, ARGS, R> {
    private val solutions = mutableListOf<S>()
    private var testcases = mutableListOf<TestCase<() -> ARGS, R>>()

    fun test(appendTestcases: MutableList<TestCase<() -> ARGS, R>>.() -> Unit) =
        testcases.apply(appendTestcases).map { (parameters, expected) ->
            DynamicTest.dynamicTest("parameters: ${convertToString(parameters())}") {
                try {
                    solutions.forEach { solution ->
                        if (expected is Iterable<*> || expected is Array<*> || expected is IntArray) {
                            assertEquals(convertToString(expected), convertToString(solution solve parameters()))
                        } else {
                            assertEquals(expected, solution solve parameters())
                        }
                    }
                } catch (e: Exception) {
                    fail(e)
                }
            }
        }.also { testcases = mutableListOf() }

    private fun <T> convertToString(v: T): String = when (v) {
        is Short -> "${v}S"
        is Long -> "${v}L"
        is Double -> "%.6fd".format(v)
        is Float -> "%.6ff".format(v)
        is Char -> "'$v'"
        is String -> "\"$v\""
        is IntArray -> v.contentToString()
        is Array<*> -> "[${v.joinToString(", ") { convertToString(it!!) }}]"
        is Pair<*, *> -> "${convertToString(v.first)}, ${convertToString(v.second)}"
        is Triple<*, *, *> -> "${convertToString(v.first)}, ${convertToString(v.second)}, ${convertToString(v.third)}"
        else -> v.toString()
    }

    abstract infix fun S.solve(arg: ARGS): R

    operator fun S.unaryPlus() = solutions.add(this)

    infix fun (() -> ARGS).expected(expected: R) = testcases.add(TestCase(this, expected))

    fun of(vararg nums: Int) = intArrayOf(*nums)
    fun of(vararg strings: String) = arrayOf(*strings)
    fun of(vararg arrays: IntArray) = arrayOf(*arrays)
    inline fun <reified T> of(vararg arrays: Array<T>) = arrayOf(*arrays)
}

open class TestBase1<P1, R> : TestBase<KFunction1<P1, R>, P1, R>() {
    override fun (KFunction1<P1, R>).solve(arg: P1): R = this(arg)
}

open class TestBase2<P1, P2, R> : TestBase<KFunction2<P1, P2, R>, Pair<P1, P2>, R>() {
    override fun KFunction2<P1, P2, R>.solve(arg: Pair<P1, P2>): R = this(arg.first, arg.second)

    @JvmName("argsP1")
    infix fun P1.args(p2: P2) = Pair(this, p2)

    operator fun P1.unaryPlus() = ParameterBuilder<P1, P2>(this)

    data class ParameterBuilder<P1, P2>(val p1: P1) {
        operator fun div(p2: P2) = Pair(p1, p2)
    }
}

open class TestBase3<P1, P2, P3, R> : TestBase<KFunction3<P1, P2, P3, R>, Triple<P1, P2, P3>, R>() {
    override fun KFunction3<P1, P2, P3, R>.solve(arg: Triple<P1, P2, P3>): R = this(arg.first, arg.second, arg.third)

    @JvmName("argsP1")
    infix fun P1.args(p2: P2) = Pair(this, p2)

    @JvmName("argsP2")
    infix fun P2.args(p3: P3) = Pair(this, p3)

    @JvmName("argsP1ToTriple")
    infix fun P1.args(p: Pair<P2, P3>) = Triple(this, p.first, p.second)

    @JvmName("argsP1P2ToTriple")
    infix fun Pair<P1, P2>.args(p3: P3) = Triple(this.first, this.second, p3)

    operator fun P1.unaryPlus() = ParameterBuilder1<P1, P2, P3>(this)


    data class ParameterBuilder1<P1, P2, P3>(val p1: P1) {
        operator fun div(p2: P2) = ParameterBuilder2<P1, P2, P3>(p1, p2)
    }

    data class ParameterBuilder2<P1, P2, P3>(val p1: P1, val p2: P2) {
        operator fun div(p3: P3) = Triple(p1, p2, p3)
    }
}