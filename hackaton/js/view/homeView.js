const container = document.getElementById('container');

function render(data) {
  container.innerHTML = '';

  // Crie um novo elemento div para o buttonBox
  const buttonBox = document.createElement('div');
  buttonBox.id = 'buttonBox';

  // Crie um novo elemento button
  const button = document.createElement('button');
  button.id = 'button';
  button.textContent = 'Get Started';

  // Adicione o botão ao buttonBox
  buttonBox.appendChild(button);

  // Adicione o buttonBox ao container
  container.appendChild(buttonBox);

  // Adicione o evento de clique ao botão
  button.addEventListener('click', function (event) {
    event.preventDefault();
    console.log('clicked');
    window.location.hash = '/quiz';
    // Se você estiver usando o window.location.hash para navegação, certifique-se de que a lógica está correta.
    // window.location.hash = '/quiz';
  });
}

export default { render };
