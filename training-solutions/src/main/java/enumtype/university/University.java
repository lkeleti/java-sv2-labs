package enumtype.university;

public enum University {
    ANNYE("Andrássy Gyula Budapesti Német Nyelvű Egyetem"),
    MKE("Magyar Képzőművészeti Egyetem"),
    BGE("Budapesti Gazdasági Egyetem"),
    MTE("Magyar Táncművészeti Egyetem"),
    BKTF("Budapest Kortárstánc Főiskola"),
    NJE("Neumann János Egyetem"),
    BME("Budapesti Műszaki és Gazdaságtudományi Egyetem"),
    NYE("Nyíregyházi Egyetem"),
    BTA("Baptista Teológiai Akadémia"),
    OE("Óbudai Egyetem"),
    CORVINUS("Budapesti Corvinus Egyetem"),
    PE("Pannon Egyetem"),
    DE("Debreceni Egyetem"),
    PPKE("Pázmány Péter Katolikus Egyetem"),
    DUE("Dunaújvárosi Egyetem"),
    PTE("Pécsi Tudományegyetem"),
    EDUTUS("Edutus Egyetem"),
    SOE("Soproni Egyetem"),
    EKKE("Eszterházy Károly Katolikus Egyetem"),
    SZE("Széchenyi István Egyetem"),
    ELTE("Eötvös Loránd Tudományegyetem"),
    SZFE("Színház- és Filmművészeti Egyetem"),
    GDF("Gábor Dénes Főiskola"),
    SZTE("Szegedi Tudományegyetem"),
    GFE("Gál Ferenc Egyetem"),
    THE("Tokaj-Hegyalja Egyetem"),
    KJE("Kodolányi János Egyetem"),
    TPF("Tomori Pál Főiskola"),
    MATE("Magyar Agrár- és Élettudományi Egyetem"),
    VEF("Veszprémi Érseki Főiskola"),
    ME("Miskolci Egyetem"),
    WJLF("Wesley János Lelkészképző Főiskola"),
    METU("Budapesti Metropolitan Egyetem"),
    WSUF("Wekerle Sándor Üzleti Főiskola"),
    MILTON("Milton Friedman Egyetem");

    private final String name;

    University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
