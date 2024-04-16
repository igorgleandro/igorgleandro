function render(hpHouses) {
  const container = document.querySelector('#container');
  container.innerHTML = '';

  // Container Button + Card
  const floatedBox = document.createElement('div');
  floatedBox.style.border = '2px solid #6A5ACD';
  floatedBox.style.borderRadius = '80px';
  floatedBox.style.padding = '100px';
  floatedBox.style.margin = '100px';
  floatedBox.style.boxShadow = '0 4px 8px 0 rgba(0, 0, 0, 0.2)';
  floatedBox.style.display = 'flex';
  floatedBox.style.flexDirection = 'column';
  floatedBox.style.alignItems = 'center';

  const buttonContainer = document.createElement('div');
  buttonContainer.classList.add('d-flex', 'justify-content-center', 'align-items-center', 'my-5');

  const button = document.createElement('button');
  button.className = 'btn btn-primary';
  button.innerText = 'Click here to see your House!';
  button.addEventListener('click', async e => {
    e.preventDefault();
    const { name, image } = await hpHouses(parseInt(Math.random() * 4));
    const cardContainer = document.createElement('center');

    cardContainer.innerHTML = `
      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front"> 
            <img src="${image}" alt="Avatar" style="border-radius: 5%; width: 300px; height: 300px; margin-top: 1%; margin-bottom: 1%; overflow: hidden; position: relative;"> 
            <h3 style="color: white; text-align: center;">${name}</h3> 
          </div>
          <div class="flip-card-back">
          <br>
            <h1>${name}</h1> 
            <p style="font-size: small;">Description:</p>
          </div>
        </div>
      </div>`;

    floatedBox.innerHTML = ''; // Clear previous content
    floatedBox.appendChild(buttonContainer);
    floatedBox.appendChild(cardContainer);
  });

  buttonContainer.appendChild(button);
  floatedBox.appendChild(buttonContainer);
  container.appendChild(floatedBox);
}

export default { render };



