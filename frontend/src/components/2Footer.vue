<script setup>

</script>


<template>
    <footer>
        <div id="vide">
            <div id="leFooter" class="row row-cols-2 py-2 my-2 border-top">
                <!-- div sur la partie centre "contacts" -->
                <div id="contact">
                    <!--<p>Five Cure</p>-->
                    <p> <img src="@/assets/clinique.png" alt="logo Synergia" height="60" width="110" />
                      </p>
                    <p>Service informatique de la clinique Synergia Ventoux</p>
                    <p>26, rond-point de l'Amitié 84200 Carpentras</p>
                   
                </div>

                <!-- div sur la partie droite "revenir en haut" -->
                <div id="haut">
                    <img id="fleche" src="@/assets/fleche.png" alt="Fleche sur laquelle cliquer pour revenir au haut de page"
                        height="50" width="50" />
                    <a id="revenir" title="ancre vers le haut de la page">Revenir en haut de page</a>
                </div>


            </div>

        </div>
    </footer>
</template>



<style>
#leFooter {
    bottom: 0px;
    background: -webkit-linear-gradient(to right, #838383, #c7c7c7);
    background: linear-gradient(to right, #c7c7c7, #838383);

    display: flex;

    line-height: 0.9em;
}

#vide {
    bottom: 0px;
    width: 100%;
    height: 50px;
    min-height: 20vh;
}



#img {
    margin: 1%;

}

#contact {
    color: black;
}

a:link {
    text-decoration: none;
}


a:visited {
    color: black;
}

#fleche{
    position : relative;
    top : 45px;
    left : 200px;
}

#revenir{
    position : relative;
    top : 45px;
    left : 210px;
    color : black;
}

</style>
