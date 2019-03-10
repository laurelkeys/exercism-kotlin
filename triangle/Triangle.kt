class Triangle(side1: Double, side2: Double, side3: Double) {

    constructor(side1: Int, side2: Int, side3: Int)
            : this(side1.toDouble(), side2.toDouble(), side3.toDouble())

    init {
        require(side1 * side2 * side3 > 0.0) { "Sides must be positive and non-zero." }
        require(triangleInequality(side1, side2, side3)) { "Sides violate the triangle inequality." }
    }

    val isEquilateral = side1 == side2 && side2 == side3
    val isIsosceles = side1 == side2 || side2 == side3 || side3 == side1 // !isScalene
    val isScalene = side1 != side2 && side2 != side3 && side3 != side1 // !isIsosceles

    private fun triangleInequality(x: Double, y: Double, z: Double) = (x + y > z) && (y + z > x) && (z + x > y)
}