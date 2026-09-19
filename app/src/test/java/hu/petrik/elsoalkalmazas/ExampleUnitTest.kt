package hu.petrik.elsoalkalmazas

import org.junit.Assert.assertEquals
import org.junit.Test

/*
 * Egyszerű helyi unit teszt.
 *
 * Ez a teszt a fejlesztőgépen fut, nem szükséges hozzá telefon vagy emulátor.
 * Az első órán ezt még nem kell részletesen használni, de jó tudni,
 * hogy a Kotlin függvényeink működése automatikusan is ellenőrizhető.
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        // Ellenőrizzük, hogy 2 + 2 valóban 4-et ad-e eredményül.
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addFunction_isCorrect() {
        // A saját add() függvényünket is egyszerűen tudjuk tesztelni.
        assertEquals(12, add(5, 7))
    }
}
