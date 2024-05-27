package edu.kis.vh.nursery;

/**
 * Klasa FifoRhymer rozszerza DefaultCountingOutRhymer, aby zaimplementować
 * strategię liczenia w stylu FIFO (First In First Out). Osiąga się to poprzez
 * użycie tymczasowego licznika do przechowywania i pobierania wartości w
 * kolejności FIFO.
 */
public class FifoRhymer extends DefaultCountingOutRhymer {

    private DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Nadpisuje metodę countOut, aby zaimplementować zachowanie FIFO. Metoda
     * używa tymczasowego licznika do odwrócenia kolejności elementów.
     *
     * @return pierwszy element, który został wstawiony, lub -1, jeśli licznik jest pusty.
     */
    @Override
    protected int countOut() {
        // Przenieś wszystkie elementy z tego licznika do tymczasowego licznika
        while (!callCheck()) {
            temp.countIn(super.countOut());
        }

        // Pobierz pierwszy element, który został wstawiony
        final int ret = temp.countOut();

        // Przenieś wszystkie elementy z powrotem do tego licznika
        while (!temp.callCheck()) {
            countIn(temp.countOut());
        }

        return ret;
    }
}
