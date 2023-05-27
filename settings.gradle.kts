rootProject.name = "version-catalog"

fun includeNamed(vararg names: String) {
    for (name in names) {
        include(name)
        project(":$name").name = "${rootProject.name}-$name"
    }
}

includeNamed(
    "1.19.4",
    "1.20"
)
