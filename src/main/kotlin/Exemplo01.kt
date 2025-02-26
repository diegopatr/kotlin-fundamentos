class Pessoa(val nome: String, val peso: Double, val altura: Double) { // Representa uma pessoa com nome, peso e altura

    fun calcularIMC(): Double { // Calcula o Índice de Massa Corporal (IMC) da pessoa
        return peso / (altura * altura) // Fórmula: peso dividido pela altura ao quadrado
    }

    fun classificarIMC(): String { // Classifica o IMC da pessoa de acordo com categorias pré-definidas
        val imc = calcularIMC()
        return when { // Estrutura condicional para categorizar o IMC
            imc < 18.5 -> "Abaixo do peso" // IMC abaixo de 18.5
            imc < 25.0 -> "Peso normal" // IMC entre 18.5 e 24.9
            imc < 30.0 -> "Sobrepeso" // IMC entre 25.0 e 29.9
            imc < 35.0 -> "Obesidade grau 1" // IMC entre 30.0 e 34.9
            imc < 40.0 -> "Obesidade grau 2" // IMC entre 35.0 e 39.9
            else -> "Obesidade grau 3" // IMC acima de 40.0
        }
    }
}

fun main() { // Função principal
    // Criação de instâncias da classe Pessoa com nome, peso e altura
    val pessoa1 = Pessoa("João", 80.0, 1.80) // Pessoa chamada João
    val pessoa2 = Pessoa("Maria", 65.0, 1.65) // Pessoa chamada Maria
    val pessoa3 = Pessoa("Pedro", 100.0, 1.75) // Pessoa chamada Pedro

    // Impressão do nome, IMC calculado e classificação do IMC para cada pessoa
    println("${pessoa1.nome}: IMC = ${pessoa1.calcularIMC()}, Classificação: ${pessoa1.classificarIMC()}") // Resultado de João
    println("${pessoa2.nome}: IMC = ${pessoa2.calcularIMC()}, Classificação: ${pessoa2.classificarIMC()}") // Resultado de Maria
    println("${pessoa3.nome}: IMC = ${pessoa3.calcularIMC()}, Classificação: ${pessoa3.classificarIMC()}") // Resultado de Pedro
}