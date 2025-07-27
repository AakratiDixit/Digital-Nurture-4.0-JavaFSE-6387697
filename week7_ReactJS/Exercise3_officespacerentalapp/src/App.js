import React from 'react';
import infosysImage from './infosys_office_space.jpg';
import tcsImage from './tcs_office_space.jpg';
import cognizantImage from './cognizant_office_space.jpeg';



function App() {
  // ✅ Object of one office
  const office1 = {
    name: 'Cognizant',
    rent: 45000,
    address: 'Koramangala, Bangalore',
    image: 'https://via.placeholder.com/300x200.png?text=Office+3'
  };

  // ✅ List of multiple offices
  const officeList = [
    {
      name: 'Infosys',
      rent: 45000,
      address: 'Koramangala, Bangalore',
      image: infosysImage
    },
    {
      name: 'TCS',
      rent: 65000,
      address: 'Hitech City, Hyderabad',
      image: tcsImage
    },
    {
      name: 'Cognizant',
      rent: 55000,
      address: 'Powai, Mumbai',
      image: cognizantImage
      
    }
  ];

  // JSX rendering with conditionally colored rent
  return (
    <div>
      {/* ✅ JSX Heading */}
      <h1 style={{ textAlign: 'center', marginTop: '20px' }}>
        🏢 Office Space Rental App
      </h1>

      {/* ✅ Loop through list */}
      <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center' }}>
        {officeList.map((office, index) => (
          <div key={index} style={{ 
            border: '1px solid #ccc', 
            padding: '20px', 
            margin: '10px', 
            width: '300px',
            borderRadius: '8px',
            boxShadow: '2px 2px 8px rgba(0,0,0,0.1)'
          }}>
            <img 
              src={office.image} 
              alt={office.name} 
              style={{ width: '100%', height: 'auto', borderRadius: '5px' }} 
            />
            <h2>{office.name}</h2>
            <p><strong>Address:</strong> {office.address}</p>

            {/* ✅ Conditional Color for Rent */}
            <p style={{ 
              color: office.rent < 60000 ? 'red' : 'green', 
              fontWeight: 'bold' 
            }}>
              ₹ {office.rent}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
