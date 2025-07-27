import React from 'react';

const ListOfPlayers = () => {
  const players = [
    { name: "Virat", score: 85 },
    { name: "Rohit", score: 40 },
    { name: "Gill", score: 77 },
    { name: "Hardik", score: 55 },
    { name: "Dhoni", score: 95 },
    { name: "Pant", score: 33 },
    { name: "Rahul", score: 60 },
    { name: "Jadeja", score: 71 },
    { name: "Bumrah", score: 48 },
    { name: "Shami", score: 80 },
    { name: "Kuldeep", score: 66 }
  ];

  // Use map to display players
  const allPlayers = players.map((player, index) => (
    <li key={index}>
      {player.name} - {player.score}
    </li>
  ));

  // Use arrow function to filter players with score < 70
  const lowScorers = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>{allPlayers}</ul>

      <h2>Players with score below 70</h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListOfPlayers;
