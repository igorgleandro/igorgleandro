const questions = [
    {
      question: 'Star Wars',
      answers: ['answer1', 'answer2', 'answer3', 'answer4']
    },
    {
        question: 'Rui',
        answers: ['answer6', 'answer6', 'answer3', 'answer4']
    },
    {
        question: 'Ola',
        answers: ['answer32', 'answer2', 'answer32', 'answer4']
    },
    {
        question: 'Omg',
        answers: ['answer1', 'answer2', 'answer3', 'answer4']
    },
    {
        question: 'XXXXX',
        answers: ['ola', 'answer2', 'answer3', 'answer4']
    },
    {
        question: 'Star Wars',
        answers: ['answersada', 'answer2', 'answer3', 'answer4']
    }
  ];
  
  async function getQuestion(index) {
    return questions[index]
  };
  
  async function getQuestions() {
    return questions;
  }
  
  export default { getQuestion, getQuestions };


  
  