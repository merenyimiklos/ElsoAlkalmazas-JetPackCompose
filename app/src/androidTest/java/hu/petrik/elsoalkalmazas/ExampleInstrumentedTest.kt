package hu.petrik.elsoalkalmazas

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/*
 * Instrumentált teszt.
 *
 * Ez már Android eszközön vagy emulátoron fut.
 * Első órán ezt sem kell részletesen feldolgozni;
 * most csak azt ellenőrzi, hogy az alkalmazás megfelelő csomagnévvel fut-e.
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Lekérjük a tesztelt Android alkalmazás környezetét.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        // Ellenőrizzük az alkalmazás csomagnevét.
        assertEquals("hu.petrik.elsoalkalmazas", appContext.packageName)
    }
}
