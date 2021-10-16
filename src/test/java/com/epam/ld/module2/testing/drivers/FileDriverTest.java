package com.epam.ld.module2.testing.drivers;



import org.junit.jupiter.api.Test;



import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileDriverTest {


    @Test
    void whenOnFileModeInvalidFilenamesAreProvidedThrowsAnException()  {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("ThereIsNotSuchFileNameSoItShouldThrowAnException").thenReturn("noinputfile");
        FileDriver fileDriver = new FileDriver(scanner);
        assertThrows(RuntimeException.class, () -> fileDriver.run());
    }
}