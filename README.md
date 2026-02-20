Codigo referente al primer lab de algoritmos 3.
Brian Orta
21-10447

Instrucciones de uso:
  Colocar todos los archivos .kt, el archico friends.sh, el archivo de texto input.txt y el makefile en una carpeta, ejecutar el comando "make" para crear el archivo .jar
  y luego usar el comando "./friends.sh <pesona1> <persona2>.

Descripción del programa:
  Este programa usa la implementación de un grafo con listas de adyacencias guardado en Grafo.kt y ListaAdyacenciaGrafo.kt para calcular el grado de separación entre dos
  personas de las dadas por el archivo de entrada "input.txt".

  Al recibir los nombres de entrada, el código del archvo DegreesOfSeparation.kt crea un grafo donde cada persona es un vertice y las aristas representan las relaciones entre
  las personas. Una vez se ha creado el grafo, se ejecuta la función "BFS" que, como indica el nombre, utilza el algoritmos breadth first search para encontrar el camino mas
  corto entre las dos personas, ademas de la persona de inicio la función también recibe la persona objetivo para que el algoritmo sepa cuando se puede detener, si encontró un
  camino con éxito, y pueda retornar una lista con el camino de la persona de inicio a la persona objetivo. Si BFS no encuentra un camino valido, retorna null. 

  Luego, el código utiliza la lista con el camino encontrado y utiliza su tamaño para calcular el grado de separación entre las dos personas, si el código recibe null,
  simplemente retorna -1.
