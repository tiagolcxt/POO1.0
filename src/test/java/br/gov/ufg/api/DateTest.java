package br.gov.ufg.api;

import br.gov.ufg.entity.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testConstructorAndGetters() {
        Data data = new Data(10, 8, 2024);
        assertEquals(10, data.getDia(), "O dia deve ser 10.");
        assertEquals(8, data.getMes(), "O mês deve ser 8.");
        assertEquals(2024, data.getAno(), "O ano deve ser 2024.");
    }

    @Test
    void testSetters() {
        Data data = new Data(1, 1, 2000);
        data.setDia(15);
        data.setMes(12);
        data.setAno(2025);
        assertEquals(15, data.getDia(), "O dia deve ser 15.");
        assertEquals(12, data.getMes(), "O mês deve ser 12.");
        assertEquals(2025, data.getAno(), "O ano deve ser 2025.");
    }

    @Test
    void testToString() {
        Data data = new Data(5, 11, 2023);
        assertEquals("5/11/2023", data.toString(), "A representação em string deve ser 'Date{5/11/2023}'.");
    }
}
