function navMenu(){
  const icono = document.querySelector('.nav_icono');
  const nav = document.querySelector('.nav_vinculos');
  const navLinks = document.querySelectorAll('.nav_vinculos li');
  const ocultar = document.querySelector('.cuerpo');
  const ocultarPie = document.querySelector('.pie');
  const noScroll = document.querySelector('.body');

  nav.classList.toggle('nav_activo');

  navLinks.forEach((link, index) => {
    if (link.style.animation) {
      link.style.animation = '';
    }
    else {
    link.style.animation = `navTransicion 0.3s ease forwards ${index / 8 + 0.5}s`;
  }
  });

  icono.classList.toggle('equis');
  ocultar.classList.toggle('ocultar');
  ocultarPie.classList.toggle('ocultar2');
  noScroll.classList.toggle('noScroll');

}
