import React, { Component } from 'react';

export default class CurrencyConverter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      result: null
    };
  }

  // handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // prevent full page reload
    const rupees = parseFloat(this.state.amount);
    const euro = (rupees / 80).toFixed(2); // assume ₹80 = €1
    this.setState({ result: euro });
  };

  handleChange = (e) => {
    // onChange synthetic event
    this.setState({ amount: e.target.value, result: null });
  };

  render() {
    return (
      <div style={{ marginTop: 40 }}>
        <h2 style={{ color: 'green' }}>Currency Converter</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>
              Amount (₹):
              <input
                type="number"
                value={this.state.amount}
                onChange={this.handleChange}
                style={{ marginLeft: 8 }}
              />
            </label>
          </div>
          <button type="submit" style={{ marginTop: 10 }}>
            Convert to Euro
          </button>
        </form>
        {this.state.result !== null && (
          <p>
            € <strong>{this.state.result}</strong>
          </p>
        )}
      </div>
    );
  }
}
