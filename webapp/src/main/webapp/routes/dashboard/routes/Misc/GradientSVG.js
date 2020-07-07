import React from 'react'

const GradientSVG = () => {

    return (
      <svg style={{height: 0}}>
        <defs>
          <linearGradient id="cpGradient" gradientTransform="rotate(100)">
            <stop offset="0%" stopColor="#345de6"/>
            <stop offset="100%" stopColor="#459580"/>
          </linearGradient>
        </defs>
      </svg>
    );
  }

export default GradientSVG;
