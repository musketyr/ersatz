package com.stehno.ersatz

import org.junit.Assert.*
import org.junit.Test

class KotlinExpectationsTest {

    @Test
    fun `kotlin dsl support`(){
        val server = ErsatzServer()

        server.expectations(KotlinExpectations.kotlin {
            get("/foo")
        })


    }
}

/*
       setup:
        ersatzServer.expectations({ expectations ->
            expectations.get('/foo').responds().content('This is Ersatz!!')
            expectations.get('/bar').responds().content('This is Bar!!')
        } as Consumer<Expectations>)

        ersatzServer.start()

        when:
        String text = "http://localhost:${ersatzServer.httpPort}/foo".toURL().text

        then:
        text == 'This is Ersatz!!'
 */