

document.getElementById("Home").addEventListener("click", () => {
  app.onglet = "Home";
});

document.getElementById("sauveteur").addEventListener("click", () => {
  app.onglet = "Acceuil";
  app.get_data("/sauveteurs");
});

document.querySelector("input").addEventListener("keyup", e => {
  if (e.keyCode == 13) {
    console.log(document.querySelector("input").value);
    app.get_data("/search", document.querySelector("input").value);
    app.onglet = "Find";
  }
});
