package com.example.biblia59.Rozne;

public class Ksiegi
    {
        public Ksiegi(String nazwaKsiegi, String iloscKsiag, Integer ikonaKomentarza)
            {
                NazwaKsiegi = nazwaKsiegi;
                IloscKsiag = iloscKsiag;
                IkonaKomentarza = ikonaKomentarza;
            }
        public String getNazwaKsiegi()
            {
                return NazwaKsiegi;
            }
        public String getIloscKsiag()
            {
                return IloscKsiag;
            }
        public Integer getIkonaKomentarza()
            {
                return IkonaKomentarza;
            }
        private String NazwaKsiegi;
        private String IloscKsiag;
        private Integer IkonaKomentarza;



    }
