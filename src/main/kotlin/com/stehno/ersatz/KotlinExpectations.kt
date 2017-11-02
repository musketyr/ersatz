package com.stehno.ersatz

import com.stehno.ersatz.impl.ExpectationsImpl

/**
 * Created by cjstehno on 11/2/17.
 */
class KotlinExpectations {

    companion object {
        fun kotlin(expects: Expectations.() -> Unit): Expectations {
            val cfg = ExpectationsImpl(null, null)
            cfg.expects()
            return cfg
        }
    }
}