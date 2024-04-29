const questions = [
  {
    question: '"Are you a man or a GIRL?"',
    answers: ['Man', 'Girl', `I don't know`],
  },
  {
    question: `If you were a pineapple, would you rather be in a Piña Colada at a bar or a Pineapple Mojito at a disco?`,
    answers: ['Bar', 'Nightclub'],
  },
  {
    question: `Where's your ultimate fun zone`,
    answers: ['Porto', 'Lisbon'],
  },
  {
    question: 'Which music genre turns you into a dancing jelly on the floor?',
    answers: ['Jazz', 'Pop', 'Rock', 'Techno'],
  },
  {
    question: 'What is the air-speed velocity of an unladen swallow?',
    answers: [
      'African or European Swallow?',
      'How am I supposed to know that?',
      '11 meters per second.',
    ],
  },
  {
    question: 'How many ping pong balls fit inside a limousine?',
    answers: [
      'At least 3',
      '264627181',
      '42',
      'How does this help me get a bar?',
    ],
  },
  {
    question: 'If you were a drink which would you be?',
    answers: ['Mojito', 'Caipirinha', 'Whiskey', 'Beer'],
  },
];

async function getQuestions() {
  return questions;
}

export default { getQuestions };
