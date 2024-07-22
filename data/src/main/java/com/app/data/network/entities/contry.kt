package com.app.data.network.entities


class country : ArrayList<countryItem>()

data class countryItem(
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: Currencies,
    val demonyms: Demonyms,
    val fifa: String,
    val flag: String,
    val flags: Flags1,
    val gini: Gini,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name1,
    val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val translations: Translations,
    val unMember: Boolean
)

data class CapitalInfo(
    val latlng: List<Double>
)

data class Car(
    val side: String,
    val signs: List<String>
)

data class CoatOfArms1(
    val png: String,
    val svg: String
)

data class Currencies(
    val AED: AED,
    val AFN: AFN,
    val ALL: ALL,
    val AMD: AMD,
    val AOA: AOA,
    val ARS: ARS,
    val AUD: AUD,
    val AZN: AZN,
    val BAM: BAM,
    val BBD: BBD,
    val BDT: BDT,
    val BGN: BGN,
    val BHD: BHD,
    val BIF: BIF,
    val BND: BND,
    val BOB: BOB,
    val BRL: BRL,
    val BSD: BSD,
    val BTN: BTN,
    val BWP: BWP,
    val BYN: BYN,
    val BZD: BZD,
    val CAD: CAD,
    val CDF: CDF,
    val CHF: CHF,
    val CLP: CLP,
    val CNY: CNY,
    val COP: COP,
    val CRC: CRC,
    val CUC: CUC,
    val CUP: CUP,
    val CVE: CVE,
    val CZK: CZK,
    val DJF: DJF,
    val DKK: DKK,
    val DOP: DOP,
    val DZD: DZD,
    val EGP: EGP,
    val ERN: ERN,
    val ETB: ETB,
    val EUR: EUR,
    val FJD: FJD,
    val GBP: GBP,
    val GEL: GEL,
    val GHS: GHS,
    val GMD: GMD,
    val GNF: GNF,
    val GTQ: GTQ,
    val GYD: GYD,
    val HNL: HNL,
    val HTG: HTG,
    val HUF: HUF,
    val IDR: IDR,
    val ILS: ILS,
    val INR: INR,
    val IQD: IQD,
    val IRR: IRR,
    val ISK: ISK,
    val JMD: JMD,
    val JOD: JOD,
    val JPY: JPY,
    val KES: KES,
    val KGS: KGS,
    val KHR: KHR,
    val KID: KID,
    val KMF: KMF,
    val KPW: KPW,
    val KRW: KRW,
    val KWD: KWD,
    val KZT: KZT,
    val LAK: LAK,
    val LBP: LBP,
    val LKR: LKR,
    val LRD: LRD,
    val LSL: LSL,
    val LYD: LYD,
    val MAD: MAD,
    val MDL: MDL,
    val MGA: MGA,
    val MKD: MKD,
    val MMK: MMK,
    val MNT: MNT,
    val MRU: MRU,
    val MUR: MUR,
    val MVR: MVR,
    val MWK: MWK,
    val MXN: MXN,
    val MYR: MYR,
    val MZN: MZN,
    val NAD: NAD,
    val NGN: NGN,
    val NIO: NIO,
    val NOK: NOK,
    val NPR: NPR,
    val NZD: NZD,
    val OMR: OMR,
    val PAB: PAB,
    val PEN: PEN,
    val PGK: PGK,
    val PHP: PHP,
    val PKR: PKR,
    val PLN: PLN,
    val PYG: PYG,
    val QAR: QAR,
    val RON: RON,
    val RSD: RSD,
    val RUB: RUB,
    val RWF: RWF,
    val SAR: SAR,
    val SBD: SBD,
    val SCR: SCR,
    val SDG: SDG,
    val SEK: SEK,
    val SGD: SGD,
    val SLL: SLL,
    val SOS: SOS,
    val SRD: SRD,
    val SSP: SSP,
    val STN: STN,
    val SYP: SYP,
    val SZL: SZL,
    val THB: THB,
    val TJS: TJS,
    val TMT: TMT,
    val TND: TND,
    val TOP: TOP,
    val TRY: TRY,
    val TTD: TTD,
    val TVD: TVD,
    val TZS: TZS,
    val UAH: UAH,
    val UGX: UGX,
    val USD: USD,
    val UYU: UYU,
    val UZS: UZS,
    val VES: VES,
    val VND: VND,
    val VUV: VUV,
    val WST: WST,
    val XAF: XAF,
    val XCD: XCD,
    val XOF: XOF,
    val YER: YER,
    val ZAR: ZAR,
    val ZMW: ZMW,
    val ZWL: ZWL
)

data class Demonyms(
    val eng: Eng,
    val fra: Fra
)

data class Flags1(
    val alt: String,
    val png: String,
    val svg: String
)

data class Gini(
    val `1992`: Double,
    val `1998`: Double,
    val `1999`: Double,
    val `2003`: Double,
    val `2004`: Double,
    val `2005`: Double,
    val `2006`: Double,
    val `2008`: Double,
    val `2009`: Double,
    val `2010`: Double,
    val `2011`: Double,
    val `2012`: Double,
    val `2013`: Double,
    val `2014`: Double,
    val `2015`: Double,
    val `2016`: Double,
    val `2017`: Double,
    val `2018`: Double,
    val `2019`: Double
)

data class Idd(
    val root: String,
    val suffixes: List<String>
)

data class Languages(
    val afr: String,
    val amh: String,
    val ara: String,
    val arc: String,
    val aym: String,
    val aze: String,
    val bel: String,
    val ben: String,
    val ber: String,
    val bis: String,
    val bjz: String,
    val bos: String,
    val bul: String,
    val bwg: String,
    val cat: String,
    val ces: String,
    val ckb: String,
    val cnr: String,
    val crs: String,
    val dan: String,
    val de: String,
    val deu: String,
    val div: String,
    val dzo: String,
    val ell: String,
    val eng: String,
    val est: String,
    val eus: String,
    val fas: String,
    val fij: String,
    val fil: String,
    val fin: String,
    val fra: String,
    val gil: String,
    val glc: String,
    val gle: String,
    val grn: String,
    val gsw: String,
    val hat: String,
    val heb: String,
    val her: String,
    val hgm: String,
    val hif: String,
    val hin: String,
    val hmo: String,
    val hrv: String,
    val hun: String,
    val hye: String,
    val ind: String,
    val isl: String,
    val ita: String,
    val jam: String,
    val jpn: String,
    val kat: String,
    val kaz: String,
    val kck: String,
    val khi: String,
    val khm: String,
    val kin: String,
    val kir: String,
    val kon: String,
    val kor: String,
    val kwn: String,
    val lao: String,
    val lat: String,
    val lav: String,
    val lin: String,
    val lit: String,
    val loz: String,
    val ltz: String,
    val lua: String,
    val mah: String,
    val mfe: String,
    val mkd: String,
    val mlg: String,
    val mlt: String,
    val mon: String,
    val mri: String,
    val msa: String,
    val mya: String,
    val nau: String,
    val nbl: String,
    val ndc: String,
    val nde: String,
    val ndo: String,
    val nep: String,
    val nld: String,
    val nno: String,
    val nob: String,
    val nso: String,
    val nya: String,
    val nzs: String,
    val pau: String,
    val pol: String,
    val por: String,
    val pov: String,
    val prs: String,
    val pus: String,
    val que: String,
    val roh: String,
    val ron: String,
    val run: String,
    val rus: String,
    val sag: String,
    val sin: String,
    val slk: String,
    val slv: String,
    val smi: String,
    val smo: String,
    val sna: String,
    val som: String,
    val sot: String,
    val spa: String,
    val sqi: String,
    val srp: String,
    val ssw: String,
    val swa: String,
    val swe: String,
    val tam: String,
    val tet: String,
    val tgk: String,
    val tha: String,
    val tir: String,
    val toi: String,
    val ton: String,
    val tpi: String,
    val tsn: String,
    val tso: String,
    val tuk: String,
    val tur: String,
    val tvl: String,
    val ukr: String,
    val urd: String,
    val uzb: String,
    val ven: String,
    val vie: String,
    val xho: String,
    val zdj: String,
    val zho: String,
    val zib: String,
    val zul: String
)

data class Maps1(
    val googleMaps: String,
    val openStreetMaps: String
)

data class Name1(
    val common: String,
    val nativeName: NativeName,
    val official: String
)

data class PostalCode(
    val format: String,
    val regex: String
)

data class Translations(
    val ara: Ara,
    val bre: Bre,
    val cym: Cym,
    val per: Per,
)

data class AED(
    val name: String,
    val symbol: String
)

data class AFN(
    val name: String,
    val symbol: String
)

data class ALL(
    val name: String,
    val symbol: String
)

data class AMD(
    val name: String,
    val symbol: String
)

data class AOA(
    val name: String,
    val symbol: String
)

data class ARS(
    val name: String,
    val symbol: String
)

data class AUD(
    val name: String,
    val symbol: String
)

data class AZN(
    val name: String,
    val symbol: String
)

data class BAM(
    val name: String,
    val symbol: String
)

data class BBD(
    val name: String,
    val symbol: String
)

data class BDT(
    val name: String,
    val symbol: String
)

data class BGN(
    val name: String,
    val symbol: String
)

data class BHD(
    val name: String,
    val symbol: String
)

data class BIF(
    val name: String,
    val symbol: String
)

data class BND(
    val name: String,
    val symbol: String
)

data class BOB(
    val name: String,
    val symbol: String
)

data class BRL(
    val name: String,
    val symbol: String
)

data class BSD(
    val name: String,
    val symbol: String
)

data class BTN(
    val name: String,
    val symbol: String
)

data class BWP(
    val name: String,
    val symbol: String
)

data class BYN(
    val name: String,
    val symbol: String
)

data class BZD(
    val name: String,
    val symbol: String
)

data class CAD(
    val name: String,
    val symbol: String
)

data class CDF(
    val name: String,
    val symbol: String
)

data class CHF(
    val name: String,
    val symbol: String
)

data class CLP(
    val name: String,
    val symbol: String
)

data class CNY(
    val name: String,
    val symbol: String
)

data class COP(
    val name: String,
    val symbol: String
)

data class CRC(
    val name: String,
    val symbol: String
)

data class CUC(
    val name: String,
    val symbol: String
)

data class CUP(
    val name: String,
    val symbol: String
)

data class CVE(
    val name: String,
    val symbol: String
)

data class CZK(
    val name: String,
    val symbol: String
)

data class DJF(
    val name: String,
    val symbol: String
)

data class DKK(
    val name: String,
    val symbol: String
)

data class DOP(
    val name: String,
    val symbol: String
)

data class DZD(
    val name: String,
    val symbol: String
)

data class EGP(
    val name: String,
    val symbol: String
)

data class ERN(
    val name: String,
    val symbol: String
)

data class ETB(
    val name: String,
    val symbol: String
)

data class EUR(
    val name: String,
    val symbol: String
)

data class FJD(
    val name: String,
    val symbol: String
)

data class GBP(
    val name: String,
    val symbol: String
)

data class GEL(
    val name: String,
    val symbol: String
)

data class GHS(
    val name: String,
    val symbol: String
)

data class GMD(
    val name: String,
    val symbol: String
)

data class GNF(
    val name: String,
    val symbol: String
)

data class GTQ(
    val name: String,
    val symbol: String
)

data class GYD(
    val name: String,
    val symbol: String
)

data class HNL(
    val name: String,
    val symbol: String
)

data class HTG(
    val name: String,
    val symbol: String
)

data class HUF(
    val name: String,
    val symbol: String
)

data class IDR(
    val name: String,
    val symbol: String
)

data class ILS(
    val name: String,
    val symbol: String
)

data class INR(
    val name: String,
    val symbol: String
)

data class IQD(
    val name: String,
    val symbol: String
)

data class IRR(
    val name: String,
    val symbol: String
)

data class ISK(
    val name: String,
    val symbol: String
)

data class JMD(
    val name: String,
    val symbol: String
)

data class JOD(
    val name: String,
    val symbol: String
)

data class JPY(
    val name: String,
    val symbol: String
)

data class KES(
    val name: String,
    val symbol: String
)

data class KGS(
    val name: String,
    val symbol: String
)

data class KHR(
    val name: String,
    val symbol: String
)

data class KID(
    val name: String,
    val symbol: String
)

data class KMF(
    val name: String,
    val symbol: String
)

data class KPW(
    val name: String,
    val symbol: String
)

data class KRW(
    val name: String,
    val symbol: String
)

data class KWD(
    val name: String,
    val symbol: String
)

data class KZT(
    val name: String,
    val symbol: String
)

data class LAK(
    val name: String,
    val symbol: String
)

data class LBP(
    val name: String,
    val symbol: String
)

data class LKR(
    val name: String,
    val symbol: String
)

data class LRD(
    val name: String,
    val symbol: String
)

data class LSL(
    val name: String,
    val symbol: String
)

data class LYD(
    val name: String,
    val symbol: String
)

data class MAD(
    val name: String,
    val symbol: String
)

data class MDL(
    val name: String,
    val symbol: String
)

data class MGA(
    val name: String,
    val symbol: String
)

data class MKD(
    val name: String,
    val symbol: String
)

data class MMK(
    val name: String,
    val symbol: String
)

data class MNT(
    val name: String,
    val symbol: String
)

data class MRU(
    val name: String,
    val symbol: String
)

data class MUR(
    val name: String,
    val symbol: String
)

data class MVR(
    val name: String,
    val symbol: String
)

data class MWK(
    val name: String,
    val symbol: String
)

data class MXN(
    val name: String,
    val symbol: String
)

data class MYR(
    val name: String,
    val symbol: String
)

data class MZN(
    val name: String,
    val symbol: String
)

data class NAD(
    val name: String,
    val symbol: String
)

data class NGN(
    val name: String,
    val symbol: String
)

data class NIO(
    val name: String,
    val symbol: String
)

data class NOK(
    val name: String,
    val symbol: String
)

data class NPR(
    val name: String,
    val symbol: String
)

data class NZD(
    val name: String,
    val symbol: String
)

data class OMR(
    val name: String,
    val symbol: String
)

data class PAB(
    val name: String,
    val symbol: String
)

data class PEN(
    val name: String,
    val symbol: String
)

data class PGK(
    val name: String,
    val symbol: String
)

data class PHP(
    val name: String,
    val symbol: String
)

data class PKR(
    val name: String,
    val symbol: String
)

data class PLN(
    val name: String,
    val symbol: String
)

data class PYG(
    val name: String,
    val symbol: String
)

data class QAR(
    val name: String,
    val symbol: String
)

data class RON(
    val name: String,
    val symbol: String
)

data class RSD(
    val name: String,
    val symbol: String
)

data class RUB(
    val name: String,
    val symbol: String
)

data class RWF(
    val name: String,
    val symbol: String
)

data class SAR(
    val name: String,
    val symbol: String
)

data class SBD(
    val name: String,
    val symbol: String
)

data class SCR(
    val name: String,
    val symbol: String
)

data class SDG(
    val name: String,
    val symbol: String
)

data class SEK(
    val name: String,
    val symbol: String
)

data class SGD(
    val name: String,
    val symbol: String
)

data class SLL(
    val name: String,
    val symbol: String
)

data class SOS(
    val name: String,
    val symbol: String
)

data class SRD(
    val name: String,
    val symbol: String
)

data class SSP(
    val name: String,
    val symbol: String
)

data class STN(
    val name: String,
    val symbol: String
)

data class SYP(
    val name: String,
    val symbol: String
)

data class SZL(
    val name: String,
    val symbol: String
)

data class THB(
    val name: String,
    val symbol: String
)

data class TJS(
    val name: String,
    val symbol: String
)

data class TMT(
    val name: String,
    val symbol: String
)

data class TND(
    val name: String,
    val symbol: String
)

data class TOP(
    val name: String,
    val symbol: String
)

data class TRY(
    val name: String,
    val symbol: String
)

data class TTD(
    val name: String,
    val symbol: String
)

data class TVD(
    val name: String,
    val symbol: String
)

data class TZS(
    val name: String,
    val symbol: String
)

data class UAH(
    val name: String,
    val symbol: String
)

data class UGX(
    val name: String,
    val symbol: String
)

data class USD(
    val name: String,
    val symbol: String
)

data class UYU(
    val name: String,
    val symbol: String
)

data class UZS(
    val name: String,
    val symbol: String
)

data class VES(
    val name: String,
    val symbol: String
)

data class VND(
    val name: String,
    val symbol: String
)

data class VUV(
    val name: String,
    val symbol: String
)

data class WST(
    val name: String,
    val symbol: String
)

data class XAF(
    val name: String,
    val symbol: String
)

data class XCD(
    val name: String,
    val symbol: String
)

data class XOF(
    val name: String,
    val symbol: String
)

data class YER(
    val name: String,
    val symbol: String
)

data class ZAR(
    val name: String,
    val symbol: String
)

data class ZMW(
    val name: String,
    val symbol: String
)

data class ZWL(
    val name: String,
    val symbol: String
)

data class Eng(
    val f: String,
    val m: String
)

data class Fra(
    val f: String,
    val m: String
)

data class NativeName(
    val afr: Afr,
    val amh: Amh,
    val ara: Ara,
    val arc: Arc,
    val aym: Aym,
    val aze: Aze,
    val bar: Bar,
    val bel: Bel,
    val ben: Ben,
    val ber: Ber,
    val bis: Bis,
    val bjz: Bjz,
    val bos: Bos,
    val bul: Bul,
    val bwg: Bwg,
    val cat: Cat,
    val ces: Ces,
    val ckb: Ckb,
    val cnr: Cnr,
    val crs: Crs,
    val dan: Dan,
    val deu: Deu,
    val div: Div,
    val dzo: Dzo,
    val ell: Ell,
    val eng: EngX,
    val est: Est,
    val fas: Fas,
    val fij: Fij,
    val fil: Fil,
    val fin: Fin,
    val fra: FraX,
    val gil: Gil,
    val gle: Gle,
    val grn: Grn,
    val gsw: Gsw,
    val hat: Hat,
    val heb: Heb,
    val her: Her,
    val hgm: Hgm,
    val hif: Hif,
    val hin: Hin,
    val hmo: Hmo,
    val hrv: Hrv,
    val hun: Hun,
    val hye: Hye,
    val ind: Ind,
    val isl: Isl,
    val ita: Ita,
    val jam: Jam,
    val jpn: Jpn,
    val kat: Kat,
    val kaz: Kaz,
    val kck: Kck,
    val khi: Khi,
    val khm: Khm,
    val kin: Kin,
    val kir: Kir,
    val kon: Kon,
    val kor: Kor,
    val kwn: Kwn,
    val lao: Lao,
    val lat: Lat,
    val lav: Lav,
    val lin: Lin,
    val lit: Lit,
    val loz: Loz,
    val ltz: Ltz,
    val lua: Lua,
    val mah: Mah,
    val mfe: Mfe,
    val mkd: MkdX,
    val mlg: Mlg,
    val mlt: Mlt,
    val mon: Mon,
    val mri: Mri,
    val msa: Msa,
    val mya: Mya,
    val nau: Nau,
    val nbl: Nbl,
    val ndc: Ndc,
    val nde: Nde,
    val ndo: Ndo,
    val nep: Nep,
    val nld: Nld,
    val nno: Nno,
    val nob: Nob,
    val nso: Nso,
    val nya: Nya,
    val nzs: Nzs,
    val pau: Pau,
    val pol: Pol,
    val por: Por,
    val pov: Pov,
    val prs: Prs,
    val pus: Pus,
    val que: Que,
    val roh: Roh,
    val ron: RonX,
    val run: Run,
    val rus: Rus,
    val sag: Sag,
    val sin: Sin,
    val slk: Slk,
    val slv: Slv,
    val smi: Smi,
    val smo: Smo,
    val sna: Sna,
    val som: Som,
    val sot: Sot,
    val spa: Spa,
    val sqi: Sqi,
    val srp: Srp,
    val ssw: Ssw,
    val swa: Swa,
    val swe: Swe,
    val tam: Tam,
    val tet: Tet,
    val tgk: Tgk,
    val tha: Tha,
    val tir: Tir,
    val toi: Toi,
    val ton: Ton,
    val tpi: Tpi,
    val tsn: Tsn,
    val tso: Tso,
    val tuk: Tuk,
    val tur: Tur,
    val tvl: Tvl,
    val ukr: Ukr,
    val urd: Urd,
    val uzb: Uzb,
    val ven: Ven,
    val vie: Vie,
    val xho: Xho,
    val zdj: Zdj,
    val zho: Zho,
    val zib: Zib,
    val zul: Zul
)

data class Afr(
    val common: String,
    val official: String
)

data class Amh(
    val common: String,
    val official: String
)

data class Ara(
    val common: String,
    val official: String
)

data class Arc(
    val common: String,
    val official: String
)

data class Aym(
    val common: String,
    val official: String
)

data class Aze(
    val common: String,
    val official: String
)

data class Bar(
    val common: String,
    val official: String
)

data class Bel(
    val common: String,
    val official: String
)

data class Ben(
    val common: String,
    val official: String
)

data class Ber(
    val common: String,
    val official: String
)

data class Bis(
    val common: String,
    val official: String
)

data class Bjz(
    val common: String,
    val official: String
)

data class Bos(
    val common: String,
    val official: String
)

data class Bul(
    val common: String,
    val official: String
)

data class Bwg(
    val common: String,
    val official: String
)

data class Cat(
    val common: String,
    val official: String
)

data class Ces(
    val common: String,
    val official: String
)

data class Ckb(
    val common: String,
    val official: String
)

data class Cnr(
    val common: String,
    val official: String
)

data class Crs(
    val common: String,
    val official: String
)

data class Dan(
    val common: String,
    val official: String
)

data class Deu(
    val common: String,
    val official: String
)

data class Div(
    val common: String,
    val official: String
)

data class Dzo(
    val common: String,
    val official: String
)

data class Ell(
    val common: String,
    val official: String
)

data class EngX(
    val common: String,
    val official: String
)

data class Est(
    val common: String,
    val official: String
)

data class Fas(
    val common: String,
    val official: String
)

data class Fij(
    val common: String,
    val official: String
)

data class Fil(
    val common: String,
    val official: String
)

data class Fin(
    val common: String,
    val official: String
)

data class FraX(
    val common: String,
    val official: String
)

data class Gil(
    val common: String,
    val official: String
)

data class Gle(
    val common: String,
    val official: String
)

data class Grn(
    val common: String,
    val official: String
)

data class Gsw(
    val common: String,
    val official: String
)

data class Hat(
    val common: String,
    val official: String
)

data class Heb(
    val common: String,
    val official: String
)

data class Her(
    val common: String,
    val official: String
)

data class Hgm(
    val common: String,
    val official: String
)

data class Hif(
    val common: String,
    val official: String
)

data class Hin(
    val common: String,
    val official: String
)

data class Hmo(
    val common: String,
    val official: String
)

data class Hrv(
    val common: String,
    val official: String
)

data class Hun(
    val common: String,
    val official: String
)

data class Hye(
    val common: String,
    val official: String
)

data class Ind(
    val common: String,
    val official: String
)

data class Isl(
    val common: String,
    val official: String
)

data class Ita(
    val common: String,
    val official: String
)

data class Jam(
    val common: String,
    val official: String
)

data class Jpn(
    val common: String,
    val official: String
)

data class Kat(
    val common: String,
    val official: String
)

data class Kaz(
    val common: String,
    val official: String
)

data class Kck(
    val common: String,
    val official: String
)

data class Khi(
    val common: String,
    val official: String
)

data class Khm(
    val common: String,
    val official: String
)

data class Kin(
    val common: String,
    val official: String
)

data class Kir(
    val common: String,
    val official: String
)

data class Kon(
    val common: String,
    val official: String
)

data class Kor(
    val common: String,
    val official: String
)

data class Kwn(
    val common: String,
    val official: String
)

data class Lao(
    val common: String,
    val official: String
)

data class Lat(
    val common: String,
    val official: String
)

data class Lav(
    val common: String,
    val official: String
)

data class Lin(
    val common: String,
    val official: String
)

data class Lit(
    val common: String,
    val official: String
)

data class Loz(
    val common: String,
    val official: String
)

data class Ltz(
    val common: String,
    val official: String
)

data class Lua(
    val common: String,
    val official: String
)

data class Mah(
    val common: String,
    val official: String
)

data class Mfe(
    val common: String,
    val official: String
)

data class MkdX(
    val common: String,
    val official: String
)

data class Mlg(
    val common: String,
    val official: String
)

data class Mlt(
    val common: String,
    val official: String
)

data class Mon(
    val common: String,
    val official: String
)

data class Mri(
    val common: String,
    val official: String
)

data class Msa(
    val common: String,
    val official: String
)

data class Mya(
    val common: String,
    val official: String
)

data class Nau(
    val common: String,
    val official: String
)

data class Nbl(
    val common: String,
    val official: String
)

data class Ndc(
    val common: String,
    val official: String
)

data class Nde(
    val common: String,
    val official: String
)

data class Ndo(
    val common: String,
    val official: String
)

data class Nep(
    val common: String,
    val official: String
)

data class Nld(
    val common: String,
    val official: String
)

data class Nno(
    val common: String,
    val official: String
)

data class Nob(
    val common: String,
    val official: String
)

data class Nso(
    val common: String,
    val official: String
)

data class Nya(
    val common: String,
    val official: String
)

data class Nzs(
    val common: String,
    val official: String
)

data class Pau(
    val common: String,
    val official: String
)

data class Pol(
    val common: String,
    val official: String
)

data class Por(
    val common: String,
    val official: String
)

data class Pov(
    val common: String,
    val official: String
)

data class Prs(
    val common: String,
    val official: String
)

data class Pus(
    val common: String,
    val official: String
)

data class Que(
    val common: String,
    val official: String
)

data class Roh(
    val common: String,
    val official: String
)

data class RonX(
    val common: String,
    val official: String
)

data class Run(
    val common: String,
    val official: String
)

data class Rus(
    val common: String,
    val official: String
)

data class Sag(
    val common: String,
    val official: String
)

data class Sin(
    val common: String,
    val official: String
)

data class Slk(
    val common: String,
    val official: String
)

data class Slv(
    val common: String,
    val official: String
)

data class Smi(
    val common: String,
    val official: String
)

data class Smo(
    val common: String,
    val official: String
)

data class Sna(
    val common: String,
    val official: String
)

data class Som(
    val common: String,
    val official: String
)

data class Sot(
    val common: String,
    val official: String
)

data class Spa(
    val common: String,
    val official: String
)

data class Sqi(
    val common: String,
    val official: String
)

data class Srp(
    val common: String,
    val official: String
)

data class Ssw(
    val common: String,
    val official: String
)

data class Swa(
    val common: String,
    val official: String
)

data class Swe(
    val common: String,
    val official: String
)

data class Tam(
    val common: String,
    val official: String
)

data class Tet(
    val common: String,
    val official: String
)

data class Tgk(
    val common: String,
    val official: String
)

data class Tha(
    val common: String,
    val official: String
)

data class Tir(
    val common: String,
    val official: String
)

data class Toi(
    val common: String,
    val official: String
)

data class Ton(
    val common: String,
    val official: String
)

data class Tpi(
    val common: String,
    val official: String
)

data class Tsn(
    val common: String,
    val official: String
)

data class Tso(
    val common: String,
    val official: String
)

data class Tuk(
    val common: String,
    val official: String
)

data class Tur(
    val common: String,
    val official: String
)

data class Tvl(
    val common: String,
    val official: String
)

data class Ukr(
    val common: String,
    val official: String
)

data class Urd(
    val common: String,
    val official: String
)

data class Uzb(
    val common: String,
    val official: String
)

data class Ven(
    val common: String,
    val official: String
)

data class Vie(
    val common: String,
    val official: String
)

data class Xho(
    val common: String,
    val official: String
)

data class Zdj(
    val common: String,
    val official: String
)

data class Zho(
    val common: String,
    val official: String
)

data class Zib(
    val common: String,
    val official: String
)

data class Zul(
    val common: String,
    val official: String
)

data class Bre(
    val common: String,
    val official: String
)

data class Cym(
    val common: String,
    val official: String
)

data class Per(
    val common: String,
    val official: String
)