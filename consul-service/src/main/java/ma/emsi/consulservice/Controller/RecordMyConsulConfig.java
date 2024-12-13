//package ma.emsi.consulservice.Controller;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//@ConfigurationProperties(prefix = "token")
//public record RecordMyConsulConfig(String accessTokenTimeout, String refreshTokenTimeout) { }
////
////
//// !!!!!!!! !!!!!!!! !!!!!!!! !!!!!!!! ATTENTION !!!!!!!! !!!!!!!! !!!!!!!! !!!!!!!!
////
//// J'ai un problème si j'utilise record, si je modifie les valeurs de configuration,  je ne peux pas récupérer les nouveaux valeurs
//// car record contient des attributs Final donc je dois redémarrer l'application après chaque modification.