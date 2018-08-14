package IhmFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartementDAO {

	public List<Departement> getDepartement() {
		
		List<Departement> departements = new ArrayList<>();
		
		Departement Ain = new Departement("01", "Ain");
		Departement Aisne = new Departement("02", "Aisne");
		Departement Allier = new Departement("03", "Allier");
		Departement AlpesDeHauteProvence = new Departement("04", "Alpes-de-Haute-Provence");
		Departement HautesAlpes = new Departement("05", "Hautes-Alpes");
		Departement AlpesMaritimes = new Departement("06", "Ain");
		Departement Ardeche = new Departement("07", "Ardèche");
		Departement Ardennes = new Departement("08", "Ardennes");
		Departement Ariege = new Departement("09", "Ariège");
		Departement Aube = new Departement("10", "Aube");
		Departement Aude = new Departement("11", "Aude");
		Departement Aveyron = new Departement("12", "Aveyron");
		Departement BouchesdDuRhone = new Departement("13", "Bouches-du-Rhône");
		Departement Calvados = new Departement("14", "Calvados");
		Departement Cantal = new Departement("15", "Cantal");
		Departement Charente = new Departement("16", "Charente");
		Departement CharenteMaritime = new Departement("17", "Charente-Maritime");
		Departement Cher = new Departement("18", "Cher");
		Departement Correze = new Departement("19", "Corrèze");
		Departement CoteDOr = new Departement("21", "Côte-d'Or");
		Departement CotesDArmor = new Departement("22", "Côtes-d'Armor");
		Departement Creuse = new Departement("23", "Creuse");
		Departement Dordogne = new Departement("24", "Dordogne");
		Departement Doubs = new Departement("25", "Doubs");
		Departement Drome = new Departement("26", "Drôme");
		Departement Eure = new Departement("27", "Eure");
		Departement EureEtLoir = new Departement("28", "Eure-et-Loir");
		Departement Finistere = new Departement("29", "Finistère");
		Departement CorseDuSud = new Departement("2A", "Corse-du-Sud");
		Departement HauteCorse = new Departement("2B", "Haute-Corse");
		Departement Gard = new Departement("30", "Gard");
		Departement HauteGaronne = new Departement("31", "Haute-Garonne");
		Departement Gers = new Departement("32", "Gers");
		Departement Gironde = new Departement("33", "Gironde");
		Departement Herault = new Departement("34", "Hérault");
		Departement IlleEtVilaine = new Departement("35", "Ille-et-Vilaine");
		Departement Indre = new Departement("36", "Indre");
		Departement IndreEtLoire = new Departement("37", "Indre-et-Loire");
		Departement Isere = new Departement("38", "Isère");
		Departement Jura = new Departement("39", "Jura");
		Departement Landes = new Departement("40", "Landes");
		Departement LoirEtCher = new Departement("41", "Loir-et-Cher");
		Departement Loire = new Departement("42", "Loire");
		Departement HauteLoire = new Departement("43", "Haute-Loire");
		Departement LoireAtlantique = new Departement("44", "Loire-Atlantique");
		Departement Loiret = new Departement("45", "Loiret");
		Departement Lot = new Departement("46", "Lot");
		Departement LotEtGaronne = new Departement("47", "Lot-et-Garonne");
		Departement Lozere = new Departement("48", "Lozère");
		Departement MaineEtLoire = new Departement("49", "Maine-et-Loire");
		Departement Manche = new Departement("50", "Manche");
		Departement Marne = new Departement("51", "Marne");
		Departement HauteMarne = new Departement("52", "Haute-Marne");
		Departement Mayenne = new Departement("53", "Mayenne");
		Departement MeurtheEtMoselle = new Departement("54", "Meurthe-et-Moselle");
		Departement Meuse = new Departement("55", "Meuse");
		Departement Morbihan = new Departement("56", "Morbihan");
		Departement Moselle = new Departement("57", "Moselle");
		Departement Nievre = new Departement("58", "Nièvre");
		Departement Nord = new Departement("59", "Nord");
		Departement Oise = new Departement("60", "Oise");
		Departement Orne = new Departement("61", "Orne");
		Departement PasDeCalais = new Departement("62", "Pas-de-Calais");
		Departement PuyDeDome = new Departement("63", "Puy-de-Dôme");
		Departement PyreneesAtlantiques = new Departement("64", "Pyrénées-Atlantiques");
		Departement HautesPyrenees = new Departement("65", "Hautes-Pyrénées");
		Departement PyreneesOrientales = new Departement("66", "Pyrénées-Orientales");
		Departement BasRhin = new Departement("67", "Bas-Rhin");
		Departement HautRhin = new Departement("68", "Haut-Rhin");
		Departement Rhone = new Departement("69", "Rhône");
		Departement HauteSaone = new Departement("70", "Haute-Saône");
		Departement SaoneEtLoire = new Departement("71", "Saône-et-Loire");
		Departement Sarthe = new Departement("72", "Sarthe");
		Departement Savoie = new Departement("73", "Savoie");
		Departement HauteSavoie = new Departement("74", "Haute-Savoie");
		Departement Paris = new Departement("75", "Paris");
		Departement SeineMaritime = new Departement("76", "Seine-Maritime");
		Departement SeineEtMarne = new Departement("77", "Seine-et-Marne");
		Departement Yvelines = new Departement("78", "Yvelines");
		Departement DeuxSevres = new Departement("79", "Deux-Sèvres");
		Departement Somme = new Departement("80", "Somme");
		Departement Tarn = new Departement("81", "Tarn");
		Departement TarnEtGaronne = new Departement("82", "Tarn-et-Garonne");
		Departement Var = new Departement("83", "Var");
		Departement Vaucluse = new Departement("84", "Vaucluse");
		Departement Vendee = new Departement("85", "Vendée");
		Departement Vienne = new Departement("86", "Vienne");
		Departement HauteVienne = new Departement("87", "Haute-Vienne");
		Departement Vosges = new Departement("88", "Vosges");
		Departement Yonne = new Departement("89", "Yonne");
		Departement TerritoireDeBelfort = new Departement("90", "Territoire de Belfort");
		Departement Essonne = new Departement("91", "Essonne");
		Departement HautsDeSeine = new Departement("92", "Hauts-de-Seine");
		Departement SeineSaintDenis = new Departement("93", "Seine-Saint-Denis");
		Departement ValDeMarne = new Departement("94", "Val-de-Marne");
		Departement ValDOise = new Departement("95", "Val-d'Oise");
		Departement Guadeloupe = new Departement("971", "Guadeloupe");
		Departement Martinique = new Departement("972", "Martinique");
		Departement Guyane = new Departement("973", "Guyane");
		Departement LaReunion = new Departement("974", "La Réunion");
		Departement SaintPierreEtMiquelon = new Departement("975", "Saint-Pierre-et-Miquelon");
		Departement Mayotte = new Departement("976", "Mayotte");
		Departement TerresAustralesEtAntarctiques = new Departement("984", "Terres Australes et Antarctiques");
		Departement WallisEtFutuna = new Departement("986", "Wallis et Futuna");
		Departement PolynesieFrançaise = new Departement("987", "Polynésie Française");
		Departement NouvelleCaledonie = new Departement("988", "Nouvelle-Calédonie");
		
		
		Collections.addAll(departements, Ain,Aisne,Allier,AlpesDeHauteProvence,HautesAlpes,AlpesMaritimes,Ardeche,Ardennes,Ariege,Aube,Aude,Aveyron,BouchesdDuRhone,Calvados,Cantal,Charente,CharenteMaritime,Cher,Correze,CoteDOr, CotesDArmor, Creuse ,Dordogne ,Doubs,Drome,Eure,EureEtLoir, Finistere,CorseDuSud ,HauteCorse,Gard,HauteGaronne,Gers,Gironde,Herault,IlleEtVilaine,Indre,IndreEtLoire ,Isere,Jura,Landes,LoirEtCher,Loire ,HauteLoire,LoireAtlantique ,Loiret,Lot,LotEtGaronne,Lozere,MaineEtLoire,Manche,Marne,HauteMarne ,Mayenne,MeurtheEtMoselle,Meuse,Morbihan,Moselle,Nievre ,Nord,Oise,Orne, PasDeCalais,PuyDeDome,PyreneesAtlantiques,HautesPyrenees,PyreneesOrientales,BasRhin,HautRhin,Rhone,HauteSaone,SaoneEtLoire,Sarthe,Savoie,HauteSavoie,Paris,SeineMaritime,SeineEtMarne, Yvelines,DeuxSevres,Somme,Tarn ,TarnEtGaronne,Var,Vaucluse,Vendee,Vienne, HauteVienne,Vosges,Yonne, TerritoireDeBelfort,Essonne,HautsDeSeine, SeineSaintDenis,ValDeMarne,ValDOise,Guadeloupe,Martinique,Guyane,LaReunion,SaintPierreEtMiquelon,Mayotte,TerresAustralesEtAntarctiques,WallisEtFutuna,PolynesieFrançaise ,NouvelleCaledonie);
		
		return departements;
	}
}
