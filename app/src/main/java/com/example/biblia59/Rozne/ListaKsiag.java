package com.example.biblia59.Rozne;
import com.example.biblia59.R;
import java.util.ArrayList;
import java.util.List;
public class ListaKsiag
    {
        public String ZamienNazweKsiegiNaNumerKsiegi(String NazwaKsiegi)
            {
                switch (NazwaKsiegi) {
                    case "I Mojżeszowa(Księga Rodzaju)":
                        return "1";
                    case "II Mojżeszowa(Księga Wyjścia)":
                        return "2";
                    case "III Mojżeszowa(Księga Kapłańska)":
                        return "3";
                    case "IV Mojżeszowa(Księga Liczb)":
                        return "4";
                    case "V Mojżeszowa (Księga Powtórzonego Prawa)":
                        return "5";
                    case "Księga Jozuego":
                        return "6";
                    case "Księga Sędziów":
                        return "7";
                    case "Księga Rut":
                        return "8";
                    case "I Księga Samuela":
                        return "9";
                    case "II Księga Samuela":
                        return "10";
                    case "I Księga Królewska":
                        return "11";
                    case "II Księga Królewska":
                        return "12";
                    case "I Księga Kronik":
                        return "13";
                    case "II Księga Kronik":
                        return "14";
                    case "Księga Ezdrasza":
                        return "15";
                    case "Księga Nehemiasza":
                        return "16";
                    case "Księga Estery":
                        return "17";
                    case "Księga Hioba":
                        return "18";
                    case "Księga Psalmów":
                        return "19";
                    case "Księga Przysłów":
                        return "20";
                    case "Księga Kaznodziei":
                        return "21";
                    case "Pieśń nad Pieśniami":
                        return "22";
                    case "Księga Izajasza":
                        return "23";
                    case "Księga Jeremiasza":
                        return "24";
                    case "Lamentacje":
                        return "25";
                    case "Księga Ezechiela":
                        return "26";
                    case "Księga Daniela":
                        return "27";
                    case "Księga Ozeasza":
                        return "28";
                    case "Księga Joela":
                        return "29";
                    case "Księga Amosa":
                        return "30";
                    case "Księga Abdiasza":
                        return "31";
                    case "Księga Jonasza":
                        return "32";
                    case "Księga Micheasza":
                        return "33";
                    case "Księga Nahuma":
                        return "34";
                    case "Księga Habakuka":
                        return "35";
                    case "Księga Sofoniasza":
                        return "36";
                    case "Księga Aggeusza":
                        return "37";
                    case "Księga Zachariasza":
                        return "38";
                    case "Księga Malachiasza":
                        return "39";
                    case "Ewangelia Mateusza":
                        return "40";
                    case "Ewangelia Marka":
                        return "41";
                    case "Ewangelia Łukasza":
                        return "42";
                    case "Ewangelia Jana":
                        return "43";
                    case "Dzieje Apostolskie":
                        return "44";
                    case "List do Rzymian":
                        return "45";
                    case "I List do Koryntian":
                        return "46";
                    case "II List do Koryntian":
                        return "47";
                    case "List do Galacjan":
                        return "48";
                    case "List do Efezjan":
                        return "49";
                    case "List do Filipian":
                        return "50";
                    case "List do Kolosan":
                        return "51";
                    case "I List do Tesaloniczan":
                        return "52";
                    case "II List do Tesaloniczan":
                        return "53";
                    case "I List do Tymoteusza":
                        return "54";
                    case "II List do Tymoteusza":
                        return "55";
                    case "List do Tytusa":
                        return "56";
                    case "List do Filemona":
                        return "57";
                    case "List do Hebrajczyków":
                        return "58";
                    case "List Jakuba":
                        return "59";
                    case "I List Piotra":
                        return "60";
                    case "II List Piotra":
                        return "61";
                    case "1 List Jana":
                        return "62";
                    case "2 List Jana":
                        return "63";
                    case "3 List Jana":
                        return "64";
                    case "List Judy":
                        return "65";
                    case "Księga Objawienia":
                        return "66";
                    case "Potrzebujesz Zbawienia":
                        return "700";
                    case "Nie możesz sam siebie zbawić":
                        return "701";
                    case "Bóg przygotował już dla Ciebie zbawienie":
                        return "702";
                    case "Pan Jezus ma moc, aby Cię zbawić i strzec":
                        return "703";
                    case "Odwróć się od grzechu":
                        return "704";
                    case "Uwierz w Jezusa":
                        return "705";
                    case "Wyznaj Bogu swoje grzechy":
                        return "706";
                    case "Jezus Eucharystyczny VS Jezus Biblijny":
                        return "707";
                }
                return "0";
            }
        String ZamienNumerKsiegiNaNazweKsiegi(String NumerKsiegi)
            {
            switch (NumerKsiegi) {
                case "1":   return "I Mojżeszowa(Księga Rodzaju)";
                case "2":   return "II Mojżeszowa(Księga Wyjścia)";
                case "3":   return "III Mojżeszowa(Księga Kapłańska)";
                case "4":   return "IV Mojżeszowa(Księga Liczb)";
                case "5":   return "V Mojżeszowa (Księga Powtórzonego Prawa)";
                case "6":   return "Księga Jozuego";
                case "7":   return "Księga Sędziów";
                case "8":   return "Księga Rut";
                case "9":   return "I Księga Samuela";
                case "10":  return "II Księga Samuela";
                case "11":  return "I Księga Królewska";
                case "12":  return "II Księga Królewska";
                case "13":  return "I Księga Kronik";
                case "14":  return "II Księga Kronik";
                case "15":  return "Księga Ezdrasza";
                case "16":  return "Księga Nehemiasza";
                case "17":  return "Księga Estery";
                case "18":  return "Księga Hioba";
                case "19":  return "Księga Psalmów";
                case "20":  return "Księga Przysłów";
                case "21":  return "Księga Kaznodziei";
                case "22":  return "Pieśń nad Pieśniami";
                case "23":  return "Księga Izajasza";
                case "24":  return "Księga Jeremiasza";
                case "25":  return "Lamentacje";
                case "26":  return "Księga Ezechiela";
                case "27":  return "Księga Daniela";
                case "28":  return "Księga Ozeasza";
                case "29":  return "Księga Joela";
                case "30":  return "Księga Amosa";
                case "31":  return "Księga Abdiasza";
                case "32":  return "Księga Jonasza";
                case "33":  return "Księga Micheasza";
                case "34":  return "Księga Nahuma";
                case "35":  return "Księga Habakuka";
                case "36":  return "Księga Sofoniasza";
                case "37":  return "Księga Aggeusza";
                case "38":  return "Księga Zachariasza";
                case "39":  return "Księga Malachiasza";
                case "40":  return "Ewangelia Mateusza";
                case "41":  return "Ewangelia Marka";
                case "42":  return "Ewangelia Łukasza";
                case "43":  return "Ewangelia Jana";
                case "44":  return "Dzieje Apostolskie";
                case "45":  return "List do Rzymian";
                case "46":  return "I List do Koryntian";
                case "47":  return "II List do Koryntian";
                case "48":  return "List do Galacjan";
                case "49":  return "List do Efezjan";
                case "50":  return "List do Filipian";
                case "51":  return "List do Kolosan";
                case "52":  return "I List do Tesaloniczan";
                case "53":  return "II List do Tesaloniczan";
                case "54":  return "I List do Tymoteusza";
                case "55":  return "II List do Tymoteusza";
                case "56":  return "List do Tytusa";
                case "57":  return "List do Filemona";
                case "58":  return "List do Hebrajczyków";
                case "59":  return "List Jakuba";
                case "60":  return "I List Piotra";
                case "61":  return "II List Piotra";
                case "62":  return "1 List Jana";
                case "63":  return  "2 List Jana";
                case "64":  return "3 List Jana";
                case "65":  return "List Judy";
                case "66":  return "Księga Objawienia";

            }

            return "1";
        }
        public List<Ksiegi>getStaryNowyTestament()
            {
                List<Ksiegi> lista = new ArrayList<>(80);
                lista.add(new Ksiegi("I Mojżeszowa(Księga Rodzaju)","50", 0));
                lista.add(new Ksiegi("II Mojżeszowa(Księga Wyjścia)","40", 0));
                lista.add(new Ksiegi("III Mojżeszowa(Księga Kapłańska)","27", 0));
                lista.add(new Ksiegi("IV Mojżeszowa(Księga Liczb)","36", 0));
                lista.add(new Ksiegi("V Mojżeszowa (Księga Powtórzonego Prawa)","34", 0));
                lista.add(new Ksiegi("Księga Jozuego","24", 0));
                lista.add(new Ksiegi("Księga Sędziów","21", 0));
                lista.add(new Ksiegi("Księga Rut", "4",0));
                lista.add(new Ksiegi("I Księga Samuela","31", 0));
                lista.add(new Ksiegi("II Księga Samuela","24", 0));
                lista.add( new Ksiegi("I Księga Królewska", "22",0));
                lista.add( new Ksiegi("II Księga Królewska", "25",0));
                lista.add( new Ksiegi("I Księga Kronik","29", 0));
                lista.add( new Ksiegi("II Księga Kronik","36", 0));
                lista.add( new Ksiegi("Księga Ezdrasza", "10",0));
                lista.add( new Ksiegi("Księga Nehemiasza","13", 0));
                lista.add( new Ksiegi("Księga Estery","10", 0));
                lista.add( new Ksiegi("Księga Hioba","42", 0));
                lista.add( new Ksiegi("Księga Psalmów","150", 0));
                lista.add( new Ksiegi("Księga Przysłów","31", 0));
                lista.add( new Ksiegi("Księga Kaznodziei","12", R.drawable.reading));
                lista.add( new Ksiegi("Pieśń nad Pieśniami","8", 0));
                lista.add( new Ksiegi("Księga Izajasza","66", 0));
                lista.add( new Ksiegi("Księga Jeremiasza","52", 0));
                lista.add( new Ksiegi("Lamentacje","5", 0));
                lista.add( new Ksiegi("Księga Ezechiela","48", 0));
                lista.add( new Ksiegi("Księga Daniela","14", 0));
                lista.add( new Ksiegi("Księga Ozeasza","14", 0));
                lista.add( new Ksiegi("Księga Joela","3", 0));
                lista.add( new Ksiegi("Księga Amosa","9", 0));
                lista.add( new Ksiegi("Księga Abdiasza","1", 0));
                lista.add( new Ksiegi("Księga Jonasza","4", 0));
                lista.add( new Ksiegi("Księga Micheasza","7", 0));
                lista.add( new Ksiegi("Księga Nahuma","3", 0));
                lista.add( new Ksiegi("Księga Habakuka","3", 0));
                lista.add( new Ksiegi("Księga Sofoniasza","3", 0));
                lista.add( new Ksiegi("Księga Aggeusza","2", 0));
                lista.add( new Ksiegi("Księga Zachariasza","14", 0));
                lista.add( new Ksiegi("Księga Malachiasza","4", 0));
                lista.add( new Ksiegi("Ewangelia Mateusza","28", 0));
                lista.add( new Ksiegi("Ewangelia Marka","16", 0));
                lista.add( new Ksiegi("Ewangelia Łukasza","24", 0));
                lista.add( new Ksiegi("Ewangelia Jana","21", 0));
                lista.add( new Ksiegi("Dzieje Apostolskie","28", 0));
                lista.add( new Ksiegi("List do Rzymian","16", R.drawable.reading));
                lista.add( new Ksiegi("I List do Koryntian","16", R.drawable.reading));
                lista.add( new Ksiegi("II List do Koryntian","16", R.drawable.reading));
                lista.add( new Ksiegi("List do Galacjan","6", 0));
                lista.add( new Ksiegi("List do Efezjan","6", 0));
                lista.add( new Ksiegi("List do Filipian","4", 0));
                lista.add( new Ksiegi("List do Kolosan","4", R.drawable.reading));
                lista.add( new Ksiegi("I List do Tesaloniczan","5", 0));
                lista.add( new Ksiegi("II List do Tesaloniczan","3", 0));
                lista.add( new Ksiegi("I List do Tymoteusza","6", 0));
                lista.add( new Ksiegi("II List do Tymoteusza","4", 0));
                lista.add( new Ksiegi("List do Tytusa","3", 0));
                lista.add( new Ksiegi("List do Filemona","1", 0));
                lista.add( new Ksiegi("List do Hebrajczyków","13", R.drawable.reading));
                lista.add( new Ksiegi("List Jakuba","5", 0));
                lista.add( new Ksiegi("I List Piotra","5", 0));
                lista.add( new Ksiegi("II List Piotra","3", 0));
                lista.add( new Ksiegi("1 List Jana","5", 0));
                lista.add( new Ksiegi("2 List Jana","1", 0));
                lista.add( new Ksiegi("3 List Jana","1", 0));
                lista.add( new Ksiegi("List Judy","1", 0));
                lista.add( new Ksiegi("Księga Objawienia","22", 0));
                lista.add( new Ksiegi("Księga Kaznodziei","12", R.drawable.reading));
                lista.add(new Ksiegi("List do Rzymian","", R.drawable.reading));
                lista.add(new Ksiegi("I List do Koryntian","", R.drawable.reading));
                lista.add(new Ksiegi("II List do Koryntian","", R.drawable.reading));
                lista.add( new Ksiegi("List do Kolosan","4", R.drawable.reading));
                lista.add(new Ksiegi("List do Hebrajczyków","", R.drawable.reading));
                lista.add( new Ksiegi("Potrzebujesz Zbawienia","1", 0));
                lista.add( new Ksiegi("Nie możesz sam siebie zbawić","1", 0));
                lista.add( new Ksiegi("Bóg przygotował już dla Ciebie zbawienie","1", 0));
                lista.add( new Ksiegi("Pan Jezus ma moc, aby Cię zbawić i strzec","1", 0));
                lista.add( new Ksiegi("Odwróć się od grzechu","1", 0));
                lista.add( new Ksiegi("Uwierz w Jezusa","1", 0));
                lista.add( new Ksiegi("Wyznaj Bogu swoje grzechy","1", 0));
                lista.add( new Ksiegi("Jezus Eucharystyczny VS Jezus Biblijny","1", 0));





                return lista;
            }
    }
