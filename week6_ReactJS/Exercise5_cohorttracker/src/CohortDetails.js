import React from 'react';
import styles from './CohortDetails.module.css'; // Import the CSS module

function CohortDetails({ name, status, mentor }) {
  // inline style logic for h3
  const headingStyle = {
    color: status === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{name}</h3>
      <dl>
        <dt>Status:</dt>
        <dd>{status}</dd>
        <dt>Mentor:</dt>
        <dd>{mentor}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;