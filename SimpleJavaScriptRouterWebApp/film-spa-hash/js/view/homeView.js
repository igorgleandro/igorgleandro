function render(hpHouses) {
  const container = document.querySelector('#container');
  container.innerHTML = '';

  const buttonContainer = document.createElement('div');
  buttonContainer.classList.add('d-flex', 'justify-content-center', 'align-items-center', 'my-5');

  const button = document.createElement('button');
  button.className = 'btn btn-primary';
  button.innerText = 'Click here to see your House!';
  button.addEventListener('click', async e => {
    e.preventDefault();
    const { name, image } = await hpHouses(parseInt(Math.random() * 4));
    const cardContainer = document.createElement('div');
    cardContainer.className = 'text-center';

    cardContainer.innerHTML = `
      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front"> 
            <img src="${image}" alt="Avatar" style="border-radius: 5%; width: 300px; height: 300px; margin-top: 1%; margin-bottom: 1%; overflow: hidden; position: relative;"> 
            <h3 style="color: white; text-align: center;">${name}</h3> 
          </div>
          <div class="flip-card-back">
            <h1>${name}</h1> 
            <p style="font-size: small;">Description:</p>
          </div>
        </div>
      </div>`;

    container.innerHTML = '';
    container.appendChild(buttonContainer);
    container.appendChild(cardContainer);
  });

  buttonContainer.appendChild(button);
  container.appendChild(buttonContainer);
}

export default { render };


