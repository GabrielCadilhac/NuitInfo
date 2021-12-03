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
  props: ["onglet"],
  template: `
    <nav class="Menu_Vectical">
        <ul>
            <li><a href="#" class="Accueil">Acceuil</a></li>
            <li><a href="" v-on:cick="onglet='Acceuil'">Sauveteurs</a></li>
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
  props: [],
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
