**TASK 2**

@Qualifier -- autoviring dagi conflictlarni to`g`rilash uchun ishlariladi. Yani bir xil typedagi bir nechta beanlar mavjud bo`lsa. Bu annotatsiya ni @Component anotatsiyasiyali va @Bean bilan belgilangan methodlar bilan ishlatilinadi. Misol:

public interface A{
     public void do();
     public void stop();
}


@Component(value="aa")public class AA implements A{

     @Override
     public void do() {
           System.out.println("AA started");
     }

     @Override
     public void stop() {
           System.out.println("AA stopped");
     }
 }

@Component(value="bb")public class BB implements A{

     @Override
     public void do() {
          System.out.println("BB started");
     }

     @Override
     public void stop() {
          System.out.println("BB stopped");
     }
}

--Service qismida :
@Componentpublic class AService {

    @Autowired
    @Qualifier("aa")
    private A aa;

    public void service() {
         vehicle.do();
         vehicle.stop();
    }
}


@Scope
Bu bean tegishli annotatsiya bo`lib, uning qachon yaratilib qachon tugatishni Bean belgilaydi. Uning 6 ta turi bor. Defoult holatda singleton
singleton
prototype
request
session
application
Websocket

@ModelAttribute - bu method parametri yoki methodning qaytuvchi qiymatini berilgan model atributiga bog'laydigan va keyin uni veb-ko'rinishga chiqaradigan annotatsiya. Iz bundan method parametri va Method levelda foydalanamiz:
Method level:
u methodning ishi bir yoki bir nechta model atributlarini qo'shish ekanligini ko'rsatadi. Bunday methodlar @RequestMapping methoodlari bilan bir xil argument turlarini qo'llab-quvvatlaydi, lekin ularni to'g'ridan-to'g'ri so'rovlar bilan taqqoslab bo'lmaydi.
Exm: 
@ModelAttribute 
public void addAttributes(Model model) { 
model.addAttribute("message", "hello"); }

As Method argument:
Annotatsiyani method argumenti sifatida ishlatganimizda, u argumentni modeldan olishni bildiradi. Annotatsiya mavjud bo'lmaganda, uinstantiated qilinishi kerak va keyin modelga qo'shilishi kerak. Modelda mavjud bo'lgandan so'ng, argumentlar maydonlari nomlari mos keladigan barcha so'rov parametrlaridan to'ldirilishi kerak.

Thymeleaf, Groovy, FreeMarker, Jade.

Thymeleaf - bu HTML, XML, matn, JavaScript yoki CSS fayllarini qayta ishlay oladigan Java template enginei hisoblanadi. Boshqa template enginelardan farqli o'laroq, Thymeleaf shablonlarni prototip sifatida ishlatishga imkon beradi, ya'ni ularni statik fayllar sifatida ko'rish mumkin.

FreeMarker - bu Apache Software Foundation tomonidan yaratilgan Java-ga asoslangan template enginei.

Spring MVC ko'rinishlari Groovy Markup Template Engine yordamida ham yaratilishi mumkin. Ushbu vosita quruvchi sintaksisiga asoslangan va har qanday matn formatini yaratish uchun ishlatilishi mumkin.

Jade4j - Javascript uchun Pug template enginening (dastlab Jade nomi bilan tanilgan) Java ilovasi. Jade4j shablonlari HTML fayllarini yaratish uchun ishlatilishi mumkin.

Nomidan malumki, @RequestParam URL dan so'rov parametrlarini olish uchun ishlatiladi, @PathVariable esa URI dan qiymatlarni chiqaradi.@PathVariable URI yo'lidan qiymatlarni chiqarayotganligi sababli u encodlanmagan. @RequestParam esa  excodlangan.
