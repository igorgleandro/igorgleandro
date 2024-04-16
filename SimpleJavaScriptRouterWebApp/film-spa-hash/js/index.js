import router from '/js/router.js';

addEventListener('DOMContentLoaded', () => {
  router.init();
}
)

document.getElementById('about-us-footer').addEventListener('click', function() {
  this.classList.toggle('expanded');
});
