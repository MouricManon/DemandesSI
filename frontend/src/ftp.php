<?php
//il faut réussir à récupérer la téléversation du coup pas le mettre en route mtn

define('CONFIG_SERVER',   '192.1.2.81');  // Adresse du serveur FTP
define('CONFIG_USERNAME', 'mmouric');  // Nom d'utilisateur
define('CONFIG_PASSWORD', 'Szu97xmm!');  // Mot de passe
define('CONFIG_TIMEOUT',  2);      // Délai de connexion, en secondes

if(! empty($_FILES['fichier']) && $_FILES['fichier']['error'] == UPLOAD_ERR_OK && is_uploaded_file($_FILES['fichier']['tmp_name']))
{
  $file = $_FILES['fichier']['tmp_name'];   // Le fichier téléversé
  $dest = '/envoiDemandes' . $_FILES['fichier']['name']; // Sa destination

  $conn_id = ftp_connect(CONFIG_SERVER);   // Création de la connexion au serveur FTP

  if(empty($conn_id))
  {
    echo 'Échec de la connexion à ' . CONFIG_SERVER;
  }
  else
  {
    // Définition du délai de connexion
    ftp_set_option($conn_id, FTP_TIMEOUT_SEC, CONFIG_TIMEOUT);

    echo 'Connecté au serveur FTP.<br/>';
        
    // Identification avec le nom d'utilisateur et le mot de passe
    $login_result = ftp_login($conn_id, CONFIG_USERNAME, CONFIG_PASSWORD);

    if(!$login_result)
    {
      echo 'Échec d\'identification à ' . CONFIG_SERVER;
    }
    else
    {
      // Tentative de chargement sur le serveur FTP
      if(ftp_put($conn_id, $dest, $file, FTP_BINARY))
        echo 'Le fichier a été envoyé avec succès';
      else
        echo 'Problème lors de l\'envoi du fichier';
    }
    //Fermeture de la connexion
    ftp_close($conn_id);
  }
}