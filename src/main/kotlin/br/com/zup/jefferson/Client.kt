package br.com.zup.jefferson

import io.grpc.ManagedChannelBuilder

fun main(){

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("123.123.123-00")
        .setIdade(23)
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua Baixada da cocota")
            .setCep("42121212")
            .setComplemento("Casa 20")
            .build())
        .build()
    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)
    println(response)

}