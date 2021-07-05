package br.com.zup.jefferson

import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){
    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("123.123.123-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua Baixada da cocota")
            .setCep("42121212")
            .setComplemento("Casa 20")
            .build())
        .build()
    println(request)

    //escrevemos o objeto no arquivo ou rede
    request.writeTo(FileOutputStream("funcionario-request-bin"))

    //lemos o objeto no arquivo ou rede
    val request2 = FuncionarioRequest.newBuilder().mergeFrom(FileInputStream("funcionario-request-bin"))
    request2.setCargo(Cargo.GERENTE).build()

    println(request2)
}