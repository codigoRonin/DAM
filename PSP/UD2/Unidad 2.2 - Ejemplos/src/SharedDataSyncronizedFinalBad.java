public class SharedDataSyncronizedFinalBad {
        int data;
        boolean available = false;
    
        public synchronized int get() {
            
// Al usar un bucle while en lugar de una declaración if, 
// te aseguras de verificar la condición nuevamente después de salir 
// de la espera (wait()). Esto evita que el consumidor consuma datos 
// antes de que se produzcan.

            while (!available) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            available = false;
            notify();
            return data;
        }
        
        public synchronized void put(int newData) {
            while (available) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            data = newData;
            available = true;
            notify();
        }
    }

