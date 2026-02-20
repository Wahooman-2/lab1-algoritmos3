import java.io.File

fun BFS(start: String, end: String, graph: Grafo<String>): List<String>? {
    if (!graph.contiene(start) || !graph.contiene(end)) return null
    val visited = mutableSetOf<String>()
    val predecessor = mutableMapOf<String, String?>()
    val queue = ArrayDeque<String>()
    queue.addLast(start)
    visited.add(start)
    predecessor[start] = null

    var found = false
    while (queue.isNotEmpty()) {
        val v = queue.removeFirst()
        if (v == end) {
            found = true
            break
        }
        for (successor in graph.obtenerArcosSalida(v)) {
            if (successor !in visited) {
                visited.add(successor)
                predecessor[successor] = v
                queue.addLast(successor)
                if (successor == end) {
                    found = true
                    break
                }
            }
        }
        if (found) {
            break
        }
    }

    if (!found) {
        return null
    }

    val path = mutableListOf<String>()
    var current: String? = end
    while (current != null) {
        path.add(current)
        current = predecessor[current]
    }
    path.reverse()
    return path
}

fun main(args: Array<String>) {
    var degree = 0
    val person1 = args[0]
    val person2 = args[1]
    val entry = File("input.txt").readLines()
    val grafo = ListaAdyacenciaGrafo<String>()
    for (line in entry) {
        var names = line.split(" ")
        for (name in names) {
            grafo.agregarVertice(name)
        }
        grafo.conectar(names[0], names[1])
        grafo.conectar(names[1], names[0])
    }
    val path = BFS(person1, person2, grafo)
    if (path != null) {
        degree = path.size - 1
    }
    else {
        degree = -1
    }
    println(degree)
}