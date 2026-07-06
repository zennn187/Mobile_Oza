package com.example.oza_idgaf.Home.Pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oza_idgaf.R

class MenuCategoryFragment : Fragment() {

    private var category: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString(ARG_CATEGORY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu_category, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)

        val allItems = getDummyData()
        val filteredItems = allItems.filter { it.category == category }

        val adapter = MenuAdapter(filteredItems)
        recyclerView.adapter = adapter

        return view
    }

    private fun getDummyData(): List<UmkmItem> {
        return listOf(

            UmkmItem("Keripik Tempe Oza", "Kuliner khas lokal renyah", "https://picsum.photos/seed/culinary1/400/300", "Kuliner"),
            UmkmItem("Sambal Goreng Kemasan", "Kuliner pedas siap saji", "https://picsum.photos/seed/culinary2/400/300", "Kuliner"),
            UmkmItem("Bakpia Pathok Premium", "Kue legendaris rasa kacang hijau", "https://picsum.photos/seed/culinary3/400/300", "Kuliner"),
            UmkmItem("Keripik Pisang Cokelat", "Pisang lumer manis kekinian", "https://picsum.photos/seed/culinary4/400/300", "Kuliner"),
            UmkmItem("Abon Sapi Asli", "Lauk praktis bergizi tinggi", "https://picsum.photos/seed/culinary5/400/300", "Kuliner"),
            UmkmItem("Dodol Garut Otentik", "Manis, legit, dan kenyal tradisional", "https://picsum.photos/seed/culinary6/400/300", "Kuliner"),
            UmkmItem("Kopi Robusta Bubuk", "Kopi murni roasting pilihan", "https://picsum.photos/seed/culinary7/400/300", "Kuliner"),
            UmkmItem("Rendang Daging Instan", "Rendang kemasan steril tahan lama", "https://picsum.photos/seed/culinary8/400/300", "Kuliner"),
            UmkmItem("Sirup Pala Segar", "Minuman buah pala khas daerah", "https://picsum.photos/seed/culinary9/400/300", "Kuliner"),
            UmkmItem("Macaroni Daun Jeruk", "Cemilan gurih renyah favorit remaja", "https://picsum.photos/seed/culinary10/400/300", "Kuliner"),
            UmkmItem("Kue Semprong Wijen", "Kue kering tradisional renyah manis", "https://picsum.photos/seed/culinary11/400/300", "Kuliner"),
            UmkmItem("Baso Aci Instan", "Kuliner berkuah pedas praktis", "https://picsum.photos/seed/culinary12/400/300", "Kuliner"),
            UmkmItem("Sale Pisang Jari", "Cemilan pisang manis legit kering", "https://picsum.photos/seed/culinary13/400/300", "Kuliner"),
            UmkmItem("Keripik Singkong Balado", "Keripik pedas manis bumbu basah", "https://picsum.photos/seed/culinary14/400/300", "Kuliner"),
            UmkmItem("Madu Mongso Ketan", "Jajanan pasar fermentasi ketan hitam", "https://picsum.photos/seed/culinary15/400/300", "Kuliner"),
            UmkmItem("Kue Lapis Legit", "Premium kaya rempah lapis tradisional", "https://picsum.photos/seed/culinary16/400/300", "Kuliner"),
            UmkmItem("Emping Melinjo Gurih", "Keripik melinjo tipis rasa bawang", "https://picsum.photos/seed/culinary17/400/300", "Kuliner"),
            UmkmItem("Kacang Bali Asli", "Kacang kapri renyah rasa original", "https://picsum.photos/seed/culinary18/400/300", "Kuliner"),
            UmkmItem("Bumbu Pecel Madiun", "Sambal kacang instan tinggal seduh", "https://picsum.photos/seed/culinary19/400/300", "Kuliner"),
            UmkmItem("Peuyeum Bandung", "Tape singkong manis legit khas Jawa Barat", "https://picsum.photos/seed/culinary20/400/300", "Kuliner"),
            UmkmItem("Keripik Usus Ayam", "Cemilan gurih tinggi protein", "https://picsum.photos/seed/culinary21/400/300", "Kuliner"),
            UmkmItem("Sambal Roa Manado", "Sambal ikan asap roa otentik", "https://picsum.photos/seed/culinary22/400/300", "Kuliner"),
            UmkmItem("Teh Wangi Melati", "Daun teh pilihan dengan aroma melati", "https://picsum.photos/seed/culinary23/400/300", "Kuliner"),
            UmkmItem("Cokelat Batangan Lokal", "Cokelat asli dari petani nusantara", "https://picsum.photos/seed/culinary24/400/300", "Kuliner"),
            UmkmItem("Bawang Goreng Renyah", "Bawang merah murni tanpa campuran tepung", "https://picsum.photos/seed/culinary25/400/300", "Kuliner"),
            UmkmItem("Kerupuk Kulit Sapi", "Rambak gurih mekar renyah", "https://picsum.photos/seed/culinary26/400/300", "Kuliner"),
            UmkmItem("Geplak Bantul", "Manisan kelapa parut warna-warni", "https://picsum.photos/seed/culinary27/400/300", "Kuliner"),
            UmkmItem("Ondeh-Ondeh Kering", "Cemilan wijen isi kacang hijau kecil", "https://picsum.photos/seed/culinary28/400/300", "Kuliner"),
            UmkmItem("Nopia Banyumas", "Kue kering isi gula merah meleleh", "https://picsum.photos/seed/culinary29/400/300", "Kuliner"),
            UmkmItem("Krupuk Kamang", "Kerupuk singkong kuah sate padang", "https://picsum.photos/seed/culinary30/400/300", "Kuliner"),

            // === KATEGORI KERAJINAN (30 Data) ===
            UmkmItem("Tas Anyaman Pandan", "Kerajinan tangan estetik premium", "https://picsum.photos/seed/craft1/400/300", "Kerajinan"),
            UmkmItem("Batik Tulis Kain", "Kain batik handmade motif eksklusif", "https://picsum.photos/seed/craft2/400/300", "Kerajinan"),
            UmkmItem("Dompet Kulit Sapi", "Kulit asli lokal awet tahan lama", "https://picsum.photos/seed/craft3/400/300", "Kerajinan"),
            UmkmItem("Piring Lidi Kelapa", "Alat makan anyaman alami ramah lingkungan", "https://picsum.photos/seed/craft4/400/300", "Kerajinan"),
            UmkmItem("Gantungan Kunci Kayu", "Souvenir ukiran kayu custom", "https://picsum.photos/seed/craft5/400/300", "Kerajinan"),
            UmkmItem("Macrame Hiasan Dinding", "Dekorasi benang katun estetik rumah", "https://picsum.photos/seed/craft6/400/300", "Kerajinan"),
            UmkmItem("Sandal Tarumpah", "Alas kaki kulit tradisional kuat", "https://picsum.photos/seed/craft7/400/300", "Kerajinan"),
            UmkmItem("Kain Tenun Ikat", "Tenun asli ditenun manual", "https://picsum.photos/seed/craft8/400/300", "Kerajinan"),
            UmkmItem("Lilin Aromaterapi Soywax", "Kerajinan lilin wangi relaksasi", "https://picsum.photos/seed/craft9/400/300", "Kerajinan"),
            UmkmItem("Keramik Gerabah Hias", "Vas bunga estetik dari tanah liat", "https://picsum.photos/seed/craft10/400/300", "Kerajinan"),
            UmkmItem("Kotak Tisu Rotan", "Anyaman rotan sintetis pelengkap meja", "https://picsum.photos/seed/craft11/400/300", "Kerajinan"),
            UmkmItem("Patung Kayu Jepara", "Miniatur ukiran seniman lokal jepara", "https://picsum.photos/seed/craft12/400/300", "Kerajinan"),
            UmkmItem("Wayang Kulit Souvenir", "Wayang mini hiasan pajangan lemari", "https://picsum.photos/seed/craft13/400/300", "Kerajinan"),
            UmkmItem("Topeng Kayu Karakter", "Kerajinan seni topeng ukir hiasan dinding", "https://picsum.photos/seed/craft14/400/300", "Kerajinan"),
            UmkmItem("Tikar Mendong", "Alas lantai anyaman tanaman mendong sejuk", "https://picsum.photos/seed/craft15/400/300", "Kerajinan"),
            UmkmItem("Angklung Bambu Mini", "Alat musik tradisional edukasi anak", "https://picsum.photos/seed/craft16/400/300", "Kerajinan"),
            UmkmItem("Kalung Manik Kalimantan", "Aksesoris etnik handmade cantik", "https://picsum.photos/seed/craft17/400/300", "Kerajinan"),
            UmkmItem("Songket Palembang", "Kain mewah benang emas berkualitas tinggi", "https://picsum.photos/seed/craft18/400/300", "Kerajinan"),
            UmkmItem("Cermin Bingkai Kerang", "Dekorasi laut estetik pigura pantai", "https://picsum.photos/seed/craft19/400/300", "Kerajinan"),
            UmkmItem("Lampu Tidur Batok Kelapa", "Kerajinan lampu ukir unik artistik", "https://picsum.photos/seed/craft20/400/300", "Kerajinan"),
            UmkmItem("Sapu Lidi Hias", "Sapu interior bahan premium serat pilihan", "https://picsum.photos/seed/craft21/400/300", "Kerajinan"),
            UmkmItem("Caping Bambu Lukis", "Topi petani anyaman bermotif estetik", "https://picsum.photos/seed/craft22/400/300", "Kerajinan"),
            UmkmItem("Payung Geulis", "Payung kertas hiasan seni tradisional tasik", "https://picsum.photos/seed/craft23/400/300", "Kerajinan"),
            UmkmItem("Coet Batu Asli", "Cobek batu kali hitam tahan gerus", "https://picsum.photos/seed/craft24/400/300", "Kerajinan"),
            UmkmItem("Gelang Akar Bahar", "Aksesoris pria mistis alami estetik", "https://picsum.photos/seed/craft25/400/300", "Kerajinan"),
            UmkmItem("Gasing Kayu Tradisional", "Mainan jadul pemicu ketangkasan", "https://picsum.photos/seed/craft26/400/300", "Kerajinan"),
            UmkmItem("Bros Kebaya Tembaga", "Aksesoris bros etnik lapis emas", "https://picsum.photos/seed/craft27/400/300", "Kerajinan"),
            UmkmItem("Keranjang Baju Bambu", "Tempat pakaian kotor anyaman alami", "https://picsum.photos/seed/craft28/400/300", "Kerajinan"),
            UmkmItem("Talenan Kayu Estetik", "Alat masak dekorasi dapur minimalis", "https://picsum.photos/seed/craft29/400/300", "Kerajinan"),
            UmkmItem("Miniatur Kapal Pinisi", "Kerajinan botol kaca kapal legendaris", "https://picsum.photos/seed/craft30/400/300", "Kerajinan"),

            // === KATEGORI KESEHATAN (30 Data) ===
            UmkmItem("Minyak Telon Herbal", "Kesehatan alami untuk keluarga", "https://picsum.photos/seed/health1/400/300", "Kesehatan"),
            UmkmItem("Jamu Kunyit Asam", "Minuman kesehatan penyegar tubuh", "https://picsum.photos/seed/health2/400/300", "Kesehatan"),
            UmkmItem("Minyak Kelapa Murni (VCO)", "Suplemen organik multi khasiat", "https://picsum.photos/seed/health3/400/300", "Kesehatan"),
            UmkmItem("Teh Celup Daun Kelor", "Kaya antioksidan penangkal penyakit", "https://picsum.photos/seed/health4/400/300", "Kesehatan"),
            UmkmItem("Madu Hutan Murni", "Madu asli tanpa campuran gula", "https://picsum.photos/seed/health5/400/300", "Kesehatan"),
            UmkmItem("Sabun Bidara Alami", "Sabun herbal untuk kesehatan kulit", "https://picsum.photos/seed/health6/400/300", "Kesehatan"),
            UmkmItem("Kapsul Ekstrak Jahe Merah", "Penghangat tubuh dan penambah imun", "https://picsum.photos/seed/health7/400/300", "Kesehatan"),
            UmkmItem("Minyak Balur Urut", "Meredakan pegal dan nyeri sendi", "https://picsum.photos/seed/health8/400/300", "Kesehatan"),
            UmkmItem("Beras Merah Organik", "Pilihan sehat untuk diet serat", "https://picsum.photos/seed/health9/400/300", "Kesehatan"),
            UmkmItem("Garam Bambu Detoks", "Garam terapi kesehatan murni", "https://picsum.photos/seed/health10/400/300", "Kesehatan"),
            UmkmItem("Teh Serai Wangi", "Minuman herbal penenang tidur", "https://picsum.photos/seed/health11/400/300", "Kesehatan"),
            UmkmItem("Kapsul Spirulina", "Suplemen superfood ganggang hijau", "https://picsum.photos/seed/health12/400/300", "Kesehatan"),
            UmkmItem("Minyak Cengkeh Murni", "Pereda sakit gigi dan sariawan alami", "https://picsum.photos/seed/health13/400/300", "Kesehatan"),
            UmkmItem("Gula Semut Aren Low GI", "Pemanis sehat alternatif penderita diabetes", "https://picsum.photos/seed/health14/400/300", "Kesehatan"),
            UmkmItem("Bumbu Organik Non MSG", "Penyedap masakan sehat ramah anak", "https://picsum.photos/seed/health15/400/300", "Kesehatan"),
            UmkmItem("Sari Kurma Alami", "Peningkat trombosit darah dan stamina", "https://picsum.photos/seed/health16/400/300", "Kesehatan"),
            UmkmItem("Teh Mahkota Dewa", "Herbal penurun kolesterol jahat", "https://picsum.photos/seed/health17/400/300", "Kesehatan"),
            UmkmItem("Pil Manjakani", "Jamuan khusus keharmonisan kewanitaan", "https://picsum.photos/seed/health18/400/300", "Kesehatan"),
            UmkmItem("Salep Ekstrak Binahong", "Obat luar luka bakar dan gatal kulit", "https://picsum.photos/seed/health19/400/300", "Kesehatan"),
            UmkmItem("Minyak Eucalyptus", "Aromaterapi pelega pernapasan dada", "https://picsum.photos/seed/health20/400/300", "Kesehatan"),
            UmkmItem("Susu Kambing Etawa Bubuk", "Susu nutrisi paru-paru dan tulang", "https://picsum.photos/seed/health21/400/300", "Kesehatan"),
            UmkmItem("Keripik Pegagan Sehat", "Cemilan herbal peningkat fungsi otak", "https://picsum.photos/seed/health22/400/300", "Kesehatan"),
            UmkmItem("Masker Wajah Temulawak", "Skincare organik pencerah kulit kusam", "https://picsum.photos/seed/health23/400/300", "Kesehatan"),
            UmkmItem("Hand Sanitizer Lidah Buaya", "Pembersih kuman lembut tidak kering", "https://picsum.photos/seed/health24/400/300", "Kesehatan"),
            UmkmItem("Teh Bunga Telang Blue Tea", "Teh herbal biru peredam stres", "https://picsum.photos/seed/health25/400/300", "Kesehatan"),
            UmkmItem("Madu Hitam Pahit", "Madu khusus penurun kadar gula darah", "https://picsum.photos/seed/health26/400/300", "Kesehatan"),
            UmkmItem("Lulur Kopi Tradisional", "Lulur tubuh pengangkat sel kulit mati", "https://picsum.photos/seed/health27/400/300", "Kesehatan"),
            UmkmItem("Arang Aktif Charcoal", "Pemutih gigi alami antibakteri", "https://picsum.photos/seed/health28/400/300", "Kesehatan"),
            UmkmItem("Minyak Kemiri Bakar", "Nutrisi alami penyubur rambut rontok", "https://picsum.photos/seed/health29/400/300", "Kesehatan"),
            UmkmItem("Kapsul Daun Sambiloto", "Herbal alami penurun demam dan flu", "https://picsum.photos/seed/health30/400/300", "Kesehatan")
        )
    }

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String) = MenuCategoryFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
        }
    }
}