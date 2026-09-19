package hu.petrik.elsoalkalmazas.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/*
 * Az alkalmazás szövegstílusai.
 *
 * Első órán elég annyit tudni róla, hogy itt állíthatjuk be
 * a szövegek alapértelmezett betűtípusát, méretét és vastagságát.
 */
val Typography = Typography(
    // A bodyLarge az egyik általánosan használt törzsszöveg-stílus.
    bodyLarge = TextStyle(
        // A rendszer alapértelmezett betűtípusát használjuk.
        fontFamily = FontFamily.Default,

        // Normál betűvastagság.
        fontWeight = FontWeight.Normal,

        // A betűméret 16 sp.
        // Szövegnél általában sp mértékegységet használunk.
        fontSize = 16.sp,

        // A sorok közötti magasság.
        lineHeight = 24.sp,

        // A karakterek közötti távolság.
        letterSpacing = 0.5.sp
    )

    /*
     * Ugyanitt további stílusokat is megadhatnánk, például:
     *
     * titleLarge = TextStyle(
     *     fontSize = 22.sp
     * ),
     * labelSmall = TextStyle(
     *     fontSize = 11.sp
     * )
     */
)
