package com.example.command_sp_boot.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

//OLD_INFORMATION_SCHEMA=TRUE
@DataJpaTest
@ActiveProfiles("test")
class RepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void test() {

    }
}