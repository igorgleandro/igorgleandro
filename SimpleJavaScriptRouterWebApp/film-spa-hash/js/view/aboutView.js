function render() {
  const container = document.querySelector('#container');
  container.innerHTML = ''; // Removes the previous elements

  // Witchy Warning Message
  const witchyWarning = document.createElement('div');
  witchyWarning.innerHTML = `
    <div style="background-color: #6A5ACD; color: #FFFFFF; padding: 10px; border-radius: 10px; text-align: center; margin-bottom: 20px;">
      <p>🔮✨ Caution, dear seeker of knowledge! This enchanted page is imbued with spells of learning and wisdom, gathered from the depths of the mystical Google realms! ✨🔮</p>
      <p>🧙‍♀️ But beware! Our potions may occasionally bubble with unpredictability, for the magic of knowledge is as mysterious as the whispering winds of Hogwarts! 🏰🌬️</p>
      <p>📚 Venture forth with open minds and discerning wits, for herein lies a treasure trove of educational enchantments! ✨📖</p>
    </div>`;

  // Placeholder variables for the polaroid card
  const name = "Harry Potter";
  const dateOfBirth = "July 31, 1980";
  const house = "Gryffindor";
  const species = "Human";
  const wizard = "Yes";
  const ancestry = "Half-Blood";
  const patronus = "Stag";

  // Polaroid Card
  const polaroidCard = document.createElement('div');
  polaroidCard.innerHTML = ` 
    <div class="flip-card">
      <div class="flip-card-inner">
        <div class="flip-card-front">
        <img src="https://inspirationlaboratories.com/wp-content/uploads/2018/12/book-of-spells0.jpg" alt="Avatar" style="border-radius: 5%;
        width: 150px;
        height: 130px;
        margin-top: 25%;    
        overflow: hidden;
        position: relative;"> 
        </div>
        <div class="flip-card-back">
          <br>
          <h2>${name}</h2> 
          <p style="font-size: small;">Birth: ${dateOfBirth}</p>
          <br>
          <p> 🏠 House: ${house}, </p>
          <p>👽 Species: ${species}, </p>
          <p>🧙‍♀️ Wizard: ${wizard}, </p>
          <p>🧜 Ancestry: ${ancestry}, </p>
          <p>🪄 Patronus: ${patronus} </p>
        </div>
      </div>
    </div>`;

  // Append both the warning message and the card to the container
  container.appendChild(witchyWarning);
  container.appendChild(polaroidCard);
}

export default { render };

