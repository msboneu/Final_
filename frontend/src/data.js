const productos = [
  {
    "id": "1",
    "nombreExperiencia": "Visita la piedra El Peñol",
    "categoria": "Cultural",
    "destino": "Guatapé, Colombia",
    "precioBasico": 300,
    "precioPremium": 800,
    "urlImagenes": [
      "https://images.pexels.com/photos/12470935/pexels-photo-12470935.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
      "https://viajareacolombia.com/wp-content/uploads/2020/07/piedra-del-penol-1000x563.jpg",
      "https://b3172043.smushcdn.com/3172043/wp-content/uploads/2019/05/guatape-en-fin-de-semana.jpg",
      "https://i0.wp.com/elturismoencolombia.com/wp-content/uploads/2023/01/aerial-view-landscape-rock-guatape-piedra-del-penol-colombia.jpg?w=1600&ssl=1",
      "https://viajareacolombia.com/wp-content/uploads/2020/07/piedra-del-penol-1000x562.png"],
    "descripcion":
      "Explora Guatapé, la ciudad mas colorida de Colombia  en el departamento de Antioquia y se testigo del imponente peñol",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "2",
    "nombreExperiencia": "Diablos Danzantes de Yare",
    "categoria": "Cultural",
    "destino": "Miranda, Venezuela",
    "precioBasico": 90.0,
    "precioPremium": 220.0,
    "urlImagenes": [
      "https://spanish.xinhuanet.com/2016-05/27/135393413_14643545250671n.jpg",
      "https://mincultura.gob.ve/wp-content/uploads/2022/06/WhatsApp-Image-2022-06-16-at-8.59.55-PM-2-1.jpeg",
      "https://albaciudad.org/wp-content/uploads/2022/06/WhatsApp-Image-2022-06-16-at-8.59.58-PM.jpeg",
      "https://albaciudad.org/wp-content/uploads/2022/06/WhatsApp-Image-2022-06-16-at-8.59.58-PM-1.jpeg",
      "https://albaciudad.org/wp-content/uploads/2022/06/WhatsApp-Image-2022-06-16-at-8.59.54-PM.jpeg"],
    "descripcion":
      "visita el mejor desierto de Colombia, vivirás una gran experiencia",
      "cupoMaximo": 20,
      "duracionDias": 3
  },
  {
    "id": "3",
    "nombreExperiencia": "Visita Salinas Grandes",
    "categoria": "Negocios",
    "destino": "Salta",
    "precioBasico": 90.0,
    "precioPremium": 220.0,
    "urlImagenes": [
      "https://proyungas.org.ar/wp-content/uploads/2018/11/salinas-grandes-principal-0.jpg",
      "https://media.viajando.travel/p/d9e737c3ad52be6fc776bf121737179c/adjuntos/236/imagenes/000/544/0000544519/salinas-grandes-salta-jujuyjpg.jpg",
      "https://media.viajando.travel/p/1c2eb6ca341c1b4436136f0dbf1d7249/adjuntos/255/imagenes/000/391/0000391097/salta-salinas-grandes-poligonosjpg.jpg",
      "https://media.viajando.travel/p/6677a4b304cbbe6a55093a1d5da6a281/adjuntos/255/imagenes/000/391/0000391077/salta-salinas-grandes-paisajejpg.jpg",
      "https://media.viajando.travel/p/7dac3207332fb616f1a7e5eca9368ebb/adjuntos/236/imagenes/000/531/0000531819/1200x0/smart/salta-mtb-salinas-grandes-8jpg.jpg"],
    "descripcion":
      "Lleva a tu equipo de trabajo a deslumbrarse con el inugualable paisaje de las minas de sal",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "4",
    "nombreExperiencia": "Morrocoy",
    "categoria": "Relajación",
    "destino": "Falcón, Venezuela",
    "precioBasico": 200.0,
    "precioPremium": 500.0,
    "urlImagenes": [
      "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Cocotero_en_Cayo_Sombrero.jpg/800px-Cocotero_en_Cayo_Sombrero.jpg",
      "https://viajaelmundo.files.wordpress.com/2012/11/cayosombrero1.jpg?w=1568",
      "https://viajaelmundo.files.wordpress.com/2012/11/conari.jpg?w=800&h=600",
      "https://viajaelmundo.files.wordpress.com/2012/11/principal.jpg?w=800&h=533",
      "https://viajaelmundo.files.wordpress.com/2012/11/santuario.jpg?w=800&h=604"],
    "descripcion":
      "Ven a disfrutar de aguas cristalinas en los cayos del Parque Nacional Morrocoy",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "5",
    "nombreExperiencia": "Palermo, ruta gastronómica",
    "categoria": "Gastronómico",
    "destino": "Buenos Aires",
    "precioBasico": 200.0,
    "precioPremium": 500.0,
    "urlImagenes": [
      "https://media-cdn.tripadvisor.com/media/photo-p/0d/5b/26/a3/super-bife-la-dorita.jpg",
      "https://www.laguiadebuenosaires.com/wp-content/uploads/2018/06/palermo-rosedal-med.jpg",
      "https://www.laguiadebuenosaires.com/wp-content/uploads/2018/06/palermo-botanico.jpg",
      "https://img.theculturetrip.com/768x/smart/wp-content/uploads/2021/04/cwncr5.jpg",
      "https://img.theculturetrip.com/768x/smart/wp-content/uploads/2021/04/cwncjw.jpg"],
    "descripcion":
      "Animate a hacer este recorrido y descubrir los mejores cortes de carne de la ciudad",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "6",
    "nombreExperiencia": "Purmamarca",
    "categoria": "Aventura",
    "destino": "Jujuy",
    "precioBasico": 100.0,
    "precioPremium": 200.0,
    "urlImagenes": [
      "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/2c/ef/d9.jpg",
      "https://www.vivijujuy.com.ar/wp-content/uploads/2020/07/Purmamarca-Panoramica.jpg",
      "https://www.vivijujuy.com.ar/wp-content/uploads/2022/08/Cerro-de-los-siete-colores-Purmamarca-Vivi-Jujuy.webp",
      "https://www.vivijujuy.com.ar/wp-content/uploads/2022/08/Paseo-de-los-Colorados-Purmamarca.jpg",
      "https://www.vivijujuy.com.ar/wp-content/uploads/2016/07/iglesia-de-purmamarca-purmamarca-1-e1596895317914.jpg"],
    "descripcion":
      "Purmamarca es una localidad de la provincia de Jujuy, en el noroeste de Argentina. Se ubica en la base de un espectacular cerro multicolor llamado Cerro de los Siete Colores. Desde la villa, el sendero Paseo de los Colorados.",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "7",
    "nombreExperiencia": "Tafí del Valle",
    "categoria": "Aventura",
    "destino": "Tucumán",
    "precioBasico": 100.0,
    "precioPremium": 200.0,
    "urlImagenes": [
      "https://viajerosocultos.com/wp-content/uploads/2021/07/Tafi_del_Valle_-_postal-1280x720.jpg",
      "https://viajerosocultos.com/wp-content/uploads/2021/07/450px-Tafi_del_valle_1.jpg",
      "https://viajerosocultos.com/wp-content/uploads/2021/07/Museo_Jesuitico_La_Banda_Tafi_del_Valle_5.jpg",
      "https://viajerosocultos.com/wp-content/uploads/2021/07/ruins-of-quilmes-650491_1920-1024x768.jpg",
      "https://viajerosocultos.com/wp-content/uploads/2021/07/800px-Tafi_del_valle.jpg"],
    "descripcion":
      "Tafí del Valle es una ciudad de los Valles Calchaquíes, en el noroeste de Argentina. Está rodeada de altas montañas con senderos.",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "8",
    "nombreExperiencia": "Recorre el Roraima",
    "categoria": "Aventura",
    "destino": "Canaima",
    "precioBasico": 100.0,
    "precioPremium": 200.0,
    "urlImagenes": [
      "https://upload.wikimedia.org/wikipedia/commons/f/f8/Parque_Nacional_do_Monte_Roraima_%281%29.jpg",
      "https://www.clarin.com/img/2012/04/28/BkgWBPj6Xe_1256x620.jpg",
      "https://periodicoparatodos.com.ar/wp-content/uploads/2022/01/1.jpg",
      "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-674x446/0a/f8/6c/a5.jpg",
      "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-674x446/06/71/93/81.jpg"],
    "descripcion":
      "Atrevete a escalar el imponente tepuy Roraima, recorriendo unas de las formaciones mas antiguas del mundo",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "9",
    "nombreExperiencia": "Cataratas, vive la experiencia",
    "categoria": "Aventura",
    "destino": "Tucumán",
    "precioBasico": 100.0,
    "precioPremium": 200.0,
    "urlImagenes": [
      "https://media.traveler.es/photos/613768f03decec3303bab7da/master/pass/158835.jpg",
      "https://res.cloudinary.com/worldpackers/image/upload/c_fill,f_auto,q_auto,w_1024/v1/guides/article_cover/joaaigfc2lnylmmdo0fc",
      "https://turismo-en-argentina.com/wp-content/uploads/2017/10/1448996778_cataratas-del-iguazu-31.jpg",
      "https://turismo-en-argentina.com/wp-content/uploads/2017/10/60730588_347653012604930_5219209757207317236_n-819x1024.jpg",
      "https://turismo-en-argentina.com/wp-content/uploads/2017/10/61820657_397064784235927_9123053796875993510_n-1024x1022.jpg"],
    "descripcion":
      "Las cataratas del Iguazú (en portugués: cataratas do Iguaçu), llamadas popularmente en Argentina «Cataratas» o «Iguazú», son un conjunto de cataratas que se localizan en el río Iguazú, en el límite entre la provincia argentina de Misiones, el estado brasileño de Paraná y el departamento paraguayo de Alto Paraná. Están totalmente insertadas en áreas protegidas; el sector de la Argentina se encuentra dentro del parque nacional Iguazú, mientras que el de Brasil se encuentra en el Parque nacional del Iguazú. Fueron elegidas como una de las «Siete maravillas naturales del mundo»..",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "10",
    "nombreExperiencia": "parque Tayrona",
    "categoria": "Aventura",
    "destino": "sierra nevada de santa marta",
    "precioBasico": 300.0,
    "precioPremium": 500.0,
    "urlImagenes": [
      "https://upload.wikimedia.org/wikipedia/commons/7/76/Cabo_San_Juan%2C_Colombia.jpg",
      "https://practicalwanderlust.com/wp-content/uploads/2017/07/Parque-Tayrona-Colombia.jpg",
      "https://practicalwanderlust.com/wp-content/uploads/2016/07/Where-to-stay-in-Parque-Tayrona.jpg",
      "https://practicalwanderlust.com/wp-content/uploads/2016/07/The-best-hostel-in-Parque-Tayrona-Colombia.jpg",
      "https://practicalwanderlust.com/wp-content/uploads/2016/07/Eco-Hostel-Yuluka-near-Parque-Tayrona-in-Colombia.jpg"],
    "descripcion":
      "Está considerado una de las reservas ecológicas más importantes de Sudamérica, posee una gran belleza natural y abundantísima flora y fauna, contiene playas vírgenes, restos arqueológicos, cascadas y quebradas.",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
  {
    "id": "11",
    "nombreExperiencia": "Caño Cristales",
    "categoria": "Relajación",
    "destino": "sierra de la Macarena",
    "precioBasico": 300.0,
    "precioPremium": 500.0,
    "urlImagenes": [
      "https://www.nationalgeographic.com.es/medio/2014/09/16/ogrunewald_cano_cristales_24_1800x1201.jpg",
      "https://www.cano-cristales.com/wp-content/uploads/2023/02/Piscina-del-turista-en-Cano-Cristales-3.jpg",
      "https://www.cano-cristales.com/wp-content/uploads/2023/02/Cascada-Los-Pianos-en-Cano-Cristales_-2.jpg",
      "https://viajeszafiro.com/wp-content/uploads/2022/03/cano-cristales-2.jpg",
      "https://viajeszafiro.com/wp-content/uploads/2022/03/cano-cristales-3.jpg"],
    "descripcion":
      "Es llamado Río de los Cinco Colores porque a través de sus aguas cristalinas puedes observar tonos amarillos, azules, verdes, rojos y negros. Debes llegar al municipio de la Macarena y navegar en canoa por el río Guayabero hasta el Parque Nacional Natural Sierra de La Macarena",
      "cupoMaximo": 20,
      "duracionDias": 7
  },
];

export default productos;
