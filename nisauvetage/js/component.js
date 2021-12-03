Vue.component("header-menu", {
  props: ["value_recherche"],
  template: `
    <header>

      <vs-input type="text" icon-after v-model="value_recherche" placeholder="Rechercher personne/batteau">
          <i class='bx bx-lock-open-alt'></i>
          <i class="fas fa-search"></i>
      </vs-input>
    </header>`
});

Vue.component("nav-menu", {
  props: [""],
  template: `
    <nav class="Menu_Vectical">
        <ul>
            <li><a href="#" class="Accueil">Acceuil</a></li>
            <li><a href="">Sauveteurs</a></li>
            <li><a href="">Historique des sortier</a></li> <!-- Sorties en mer -->
            <li><a href="">Stations</a></li> <!-- Peut-être change de noms / fusionnner avec Services du ports  -->
            <li><a href="">Services du port</a></li>
            <li><a href="">Equipement</a></li> <!-- A changer peut-être -->
            <li><a href="">Techniques</a></li>
            <li><a href="">Histoire</a></li> <!-- Estaminte -> Anecdote (devient un menu dans la page Histoire)-->
            <li><a href="">Autre</a></li> <!-- Compléments  -->
        </ul>
    </nav>
  `
});

Vue.component("footer-menu", {
  props: [""],
  template: `
    <footer>

        <div class="box_flex">
            <div class="box">
            <img src="img/facebook_icon.png"/>
            <a href="" class="bouton">Suivez-nous sur Facebook</a>
            </div>
            <div class="box">
                <img src="img/twitter.png"/>
                <a href="" class="bouton">Suivez-nous sur Twitter</a>
            </div>
            <div class="box">
                <img src="img/mail_icon.png"/>
                <a href="" class="bouton">Suivez-nous sur Twitter</a>
            </div>
        </div>
    </footer>
  `
});


Vue.component("sauveteurs-menu", {
  props: ["answer"],
  template: `
    <h1>Quel dunkerquois n’a jamais lu les plaques commémoratives  apposées sur notre Leughenaer?</h1><br>

    <p>Sur cette page on trouvera les sauveteurs décorés de  la Légion  d’Honneur et ou du Mérite Maritime pour services rendus.</p><br>
    <p>La deuxième plaque apposée par les soins de la Société Humaine de Dunkerque rend hommage aux trois pilotes décédés dans le naufrage des TROIS SOEURS. La deuxième partie est un hommage à Jean-François Tixier sauveteur émérite des premières années de la société et qui perdra la vie en voulant sauver son prochain.</p><br>
    <p>La station de Gravelines a aussi des sauveteurs qui ont été remerciés par l’attribution de la Légion d’Honneur.</p><br>
    <p>Les légionnaires et titulaires du Mérite Maritime ont souvent été patron ou sous-patron des canots de sauvetage, patron de remorqueur, etc.</p><br>
    <p>Ces fonctions et les défraiements qui leur sont liés ont été définis dès la création de la SCSN. Extrait du réglement ici .</p><br>

    <h2>Membres fondateurs de la Société Humaine de Dunkerque</h2><br>

    <div id="pierre_tombal">
        <p v-for="i in answer">{{ i.nom }}</p>
    </div>
  `
});
