
function render(data) {
  showCategories(data);
  showDifficulty();
  showNumberOfQuestions();
  showButton();
}

let selectedCategory;
let selectedDifficulty;
let selectedRange;
// SHOW CATEGORIES

function showCategories(data) {
  const menu = document.createElement('div');

  menu.innerHTML = `<select id="options" class="form-select" aria-label="">
    <option selected>Choose a categorie</option>
  </select>`;
  $('#container').append(menu);

  data.trivia_categories.forEach((repo) => {
    const selected = `<option id="selected" value="${repo.id}">${repo.name}</option>`;
    $('#options').append(selected);
  });

  $('#options').change(function () {
    selectedCategory = $(this).val();
    console.log(selectedCategory);
  });
}

// SHOW DIFFICULTIES

function showDifficulty() {
  const menu = document.createElement('div');

  menu.innerHTML = `<select id="difficulties" class="form-select" aria-label="">
      <option selected>Choose the difficulty</option>
    </select>`;
  $('#container').append(menu);

  const difficulties = ['easy', 'medium', 'hard'];
  difficulties.forEach((difficulty, index) => {
    const option = `<option value="${difficulty}">${difficulty}</option>`;
    $('#difficulties').append(option);
  });


  $('#difficulties').change(function () {
     selectedDifficulty = $(this).val();
    console.log(selectedDifficulty);
  });
}

// SHOW NUMBER OF QUESTIONS

function showNumberOfQuestions() {
  const menu = document.createElement('div');

  menu.innerHTML = `<label id="rangeLabel" for="customRange2" class="form-label">Number of questions</label>
    <input type="range" class="form-range" min="1" max="10" id="customRange2">`;
  $('#container').append(menu);

  $('#customRange2').on('input', function () {
    selectedRange = $(this).val();
    console.log(selectedRange);
  });
}

// START QUIZ BUTTON

function showButton() {
  const button = document.createElement('div');

  button.innerHTML = `<button type="button" class="btn btn-primary btn-lg" id="buttonStart">Start Quiz</button>`;
  $('#container').append(button);

  $('#buttonStart').on('click', function (e) {
    e.preventDefault();
    window.location.hash = '/quiz';
  });
}

function returnCategory() {
  return selectedCategory;
}

function returnDifficulty() {
  return selectedDifficulty;
}

function returnRange() {
  return selectedRange;
}

export default { render, returnCategory, returnDifficulty, returnRange };
