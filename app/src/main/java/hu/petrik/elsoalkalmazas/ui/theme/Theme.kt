package hu.petrik.elsoalkalmazas.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/*
 * Az alkalmazás világos és sötét színpalettája.
 *
 * Ez már inkább Jetpack Compose / Material téma beállítás,
 * ezért első Kotlin órán elég csak annyit tudni róla,
 * hogy innen kapja az alkalmazás a megjelenéséhez használt színeket.
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /*
     * Itt további Material színeket is felülírhatnánk, például:
     *
     * background = Color(0xFFFFFBFE),
     * surface = Color(0xFFFFFBFE),
     * onPrimary = Color.White
     */
)

/*
 * Ez a composable függvény állítja be az alkalmazás Material témáját.
 *
 * darkTheme:
 *   igaz, ha a telefon sötét témát használ.
 *
 * dynamicColor:
 *   Android 12-től engedélyezheti, hogy az alkalmazás
 *   a rendszer dinamikus színeit használja.
 *
 * content:
 *   maga a felhasználói felület, amelyre a témát alkalmazzuk.
 */
@Composable
fun ElsoAlkalmazasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // A when segítségével kiválasztjuk, melyik színpalettát használjuk.
    val colorScheme = when {
        // Android 12 vagy újabb rendszeren használhatók a dinamikus színek.
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        // Régebbi rendszeren sötét témánál a saját sötét palettát használjuk.
        darkTheme -> DarkColorScheme

        // Minden más esetben a saját világos palettát használjuk.
        else -> LightColorScheme
    }

    // A MaterialTheme átadja a színeket és a tipográfiát a teljes felületnek.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
