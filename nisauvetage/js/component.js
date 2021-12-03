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
            <li id="Home">Acceuil</li>
            <li id="sauveteur">Sauveteurs</li>
            <li>Historique des sortier</li> <!-- Sorties en mer -->
            <li>Stations</li> <!-- Peut-être change de noms / fusionnner avec Services du ports  -->
            <li>Services du port</li>
            <li>Equipement</li> <!-- A changer peut-être -->
            <li>Techniques</li>
            <li>Histoire</li> <!-- Estaminte -> Anecdote (devient un menu dans la page Histoire)-->
            <li>Autre</li> <!-- Compléments  -->
            <li><a href="Trashgame.rar">TrashGame</a></li>

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
