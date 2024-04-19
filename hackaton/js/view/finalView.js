const container = document.getElementById('container');

function render(data) {
  container.innerHTML = '';

  // Crie um novo elemento div para o buttonBox
  const buttonBox = document.createElement('div');
  buttonBox.id = 'buttonBox';

  // Crie um novo elemento button
  const button = document.createElement('button');
  button.id = 'button';
  button.textContent = 'Get Final';

  // Adicione o botão ao buttonBox
  buttonBox.appendChild(button);

  // Adicione o buttonBox ao container
  container.appendChild(buttonBox);

  // Adicione o evento de clique ao botão
  button.addEventListener('click', function (event) {
    event.preventDefault();
    console.log('clicked');
    window.location.hash = '/final';
  });

  
}

export default { render };