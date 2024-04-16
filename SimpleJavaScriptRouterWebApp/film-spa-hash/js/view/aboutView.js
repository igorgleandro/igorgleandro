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
    </div>
  `;

  container.appendChild(witchyWarning);
}

export default { render };
