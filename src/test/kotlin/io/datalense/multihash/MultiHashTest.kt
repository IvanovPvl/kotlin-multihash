package io.datalense.multihash

import java.security.MessageDigest
import java.util.*
import kotlin.test.*
import org.junit.Test as test

class MultiHashTest {
    @test fun hashWithSHA256() {
        val data = "123".toUTF8ByteArray()
        val multihash = MultiHash.hashWithSHA256(data)
        val digest = MessageDigest.getInstance("SHA-256")

        assertEquals(HashType.sha2_256, multihash.hashType)
        assertTrue(Arrays.equals(multihash.hash, digest.digest(data)))
    }

    @test fun hashWithSHA512() {
        val data = "123".toUTF8ByteArray()
        val multihash = MultiHash.hashWithSHA512(data)
        val digest = MessageDigest.getInstance("SHA-512")

        assertEquals(HashType.sha2_512, multihash.hashType)
        assertTrue(Arrays.equals(multihash.hash, digest.digest(data)))
    }

    private fun String.toUTF8ByteArray() = this.toByteArray(Charsets.UTF_8)
}