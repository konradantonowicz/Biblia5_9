package com.example.biblia59.Rozne;
public class Model_danych_strong
    {

        private String slowo;
        private String nrStrong;
        public Model_danych_strong(String slowo, String nrStrong, String tlumaczenie)
            {
                this.slowo = slowo;
                this.nrStrong = nrStrong;
                this.tlumaczenie = tlumaczenie;
            }

        private String tlumaczenie;

        public String getSlowo()
            {
                return slowo;
            }
        public String getNrStrong()
            {
                return nrStrong;
            }
        public String getTlumaczenie()
            {
                return tlumaczenie;
            }


    }
